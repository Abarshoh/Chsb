package khamroev.findjob.Database.entity

import androidx.room.*

// User.kt
@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    val userId: Long = 0,

    @ColumnInfo(name = "fullname")
    val fullName: String,

    @ColumnInfo(name = "email")
    val email: String,

    @ColumnInfo(name = "password")
    val password: String,

    @ColumnInfo(name = "login")
    val login: String,

    @ColumnInfo(name = "role")
    val role: String
)
// Employee.kt
@Entity(
    tableName = "employees",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["user_id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("user_id")]
)

data class Employee(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "employee_id")
    val employeeId: Long = 0,

    @ColumnInfo(name = "user_id")
    val userId: Long,

    @ColumnInfo(name = "fields")
    val fields: String,

    @ColumnInfo(name = "work_fields")
    val workFields: String,

    @ColumnInfo(name = "info_employee")
    val employeeInfo: String
)

// Comment.kt
@Entity(
    tableName = "comments",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["user_id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("user_id")]
)


data class Comment(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "comment_id")
    val commentId: Long = 0,

    @ColumnInfo(name = "user_id")
    val userId: Long,

    @ColumnInfo(name = "comment_text")
    val commentText: String
)

// Field.kt
@Entity(tableName = "fields")
data class Field(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "field_id")
    val fieldId: Long = 0,

    @ColumnInfo(name = "field_name")
    val fieldName: String
)

// Organization.kt
@Entity(
    tableName = "organizations",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["user_id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Work::class,
            parentColumns = ["work_id"],
            childColumns = ["work_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("user_id"), Index("work_id")]
)


data class Organization(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "organization_id")
    val organizationId: Long = 0,

    @ColumnInfo(name = "organization_name")
    val organizationName: Long = 0,

    @ColumnInfo(name = "user_id")
    val userId: Long,

    @ColumnInfo(name = "organization_info")
    val organizationInfo: String,

    @ColumnInfo(name = "work_id")
    val workId: Long,

    @ColumnInfo(name = "employeelist_id")
    val employeeListId: List<Int>
)
@Entity(
    tableName = "works",
    foreignKeys = [
        ForeignKey(
            entity = Field::class,
            parentColumns = ["field_id"],
            childColumns = ["field_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Comment::class,
            parentColumns = ["comment_id"],
            childColumns = ["comment_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("field_id"), Index("comment_id")]
)



data class Work(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "work_id")
    val workId: Long = 0,

    @ColumnInfo(name = "info")
    val info: String,

    @ColumnInfo(name = "field_id")
    val fieldId: Long,

    @ColumnInfo(name = "comment_id")
    val commentId: Long,

    @ColumnInfo(name = "salary")
    val salary: Double
)
