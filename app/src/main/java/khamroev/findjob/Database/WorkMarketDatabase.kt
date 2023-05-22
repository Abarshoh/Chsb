package khamroev.findjob.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import khamroev.findjob.Database.dao.*
import khamroev.findjob.Database.entity.*

// WorkMarketDatabase.kt
@Database(
    entities = [User::class, Employee::class, Comment::class, Field::class, Organization::class, Work::class],
    version = 1
)
abstract class WorkMarketDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun employeeDao(): EmployeeDao
    abstract fun commentDao(): CommentDao
    abstract fun fieldDao(): FieldDao
    abstract fun organizationDao(): OrganizationDao
    abstract fun workDao(): WorkDao

    companion object {
        private const val DATABASE_NAME = "work_market"


        @Volatile
        private var INSTANCE: WorkMarketDatabase? = null

        fun getInstance(context: Context): WorkMarketDatabase  {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, WorkMarketDatabase::class.java, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build()
            }

            return INSTANCE!!
        }
    }
}
