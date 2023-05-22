package khamroev.findjob.Database.dao

import androidx.room.*
import khamroev.findjob.Database.entity.*

// UserDao.kt
@Dao
interface UserDao {
    @Insert
     fun insertUser(user: User)

    @Update
     fun updateUser(user: User)

    @Delete
     fun deleteUser(user: User)

    @Query("SELECT * FROM users")
     fun getAllUsers(): List<User>

    @Query("SELECT * FROM users WHERE user_id = :userId")
     fun getUserById(userId: Long): User?
}

// EmployeeDao.kt
@Dao
interface EmployeeDao {
    @Insert
     fun insertEmployee(employee: Employee)

    @Update
     fun updateEmployee(employee: Employee)

    @Delete
     fun deleteEmployee(employee: Employee)

    @Query("SELECT * FROM employees")
     fun getAllEmployees(): List<Employee>

    @Query("SELECT * FROM employees WHERE employee_id = :employeeId")
     fun getEmployeeById(employeeId: Long): Employee?

    @Query("SELECT * FROM employees WHERE user_id = :userId")
     fun getEmployeesByUserId(userId: Long): List<Employee>
}

// CommentDao.kt
@Dao
interface CommentDao {
    @Insert
     fun insertComment(comment: Comment)

    @Update
     fun updateComment(comment: Comment)

    @Delete
     fun deleteComment(comment: Comment)

    @Query("SELECT * FROM comments")
     fun getAllComments(): List<Comment>

    @Query("SELECT * FROM comments WHERE comment_id = :commentId")
     fun getCommentById(commentId: Long): Comment?
}

// FieldDao.kt
@Dao
interface FieldDao {
    @Insert
     fun insertField(field: Field)

    @Update
     fun updateField(field: Field)

    @Delete
     fun deleteField(field: Field)

    @Query("SELECT * FROM fields")
     fun getAllFields(): List<Field>

    @Query("SELECT * FROM fields WHERE field_id = :fieldId")
     fun getFieldById(fieldId: Long): Field?
}

// OrganizationDao.kt
@Dao
interface OrganizationDao {
    @Insert
     fun insertOrganization(organization: Organization)

    @Update
     fun updateOrganization(organization: Organization)

    @Delete
     fun deleteOrganization(organization: Organization)

    @Query("SELECT * FROM organizations")
     fun getAllOrganizations(): List<Organization>

    @Query("SELECT * FROM organizations WHERE organization_id = :organizationId")
     fun getOrganizationById(organizationId: Long): Organization?

    @Query("SELECT * FROM organizations WHERE organization_name LIKE :organizationName")
     fun getOrganizationsByName(organizationName: String): List<Organization>
}

// WorkDao.kt
@Dao
interface WorkDao {
    @Insert
     fun insertWork(work: Work)

    @Update
     fun updateWork(work: Work)

    @Delete
     fun deleteWork(work: Work)

    @Query("SELECT * FROM works")
     fun getAllWorks(): List<Work>

    @Query("SELECT * FROM works WHERE work_id = :workId")
     fun getWorkById(workId: Long): Work?

    @Query("SELECT * FROM works WHERE salary BETWEEN :minSalary AND :maxSalary")
     fun getWorksBySalary(minSalary: Double, maxSalary: Double): List<Work>

    @Query("SELECT * FROM works WHERE field_id = :fieldId")
     fun getWorksByField(fieldId: Long): List<Work>

}
