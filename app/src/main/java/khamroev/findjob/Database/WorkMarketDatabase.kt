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
        @Volatile
        private var INSTANCE: WorkMarketDatabase? = null

        fun getDatabase(context: Context): WorkMarketDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WorkMarketDatabase::class.java,
                    "work_market_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
