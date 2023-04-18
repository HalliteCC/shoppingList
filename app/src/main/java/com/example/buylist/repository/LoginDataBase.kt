package com.example.buylist.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.buylist.model.LoginModel

@Database(entities = [LoginModel::class], version = 1)
abstract class LoginDataBase : RoomDatabase() {

    abstract fun loginDao(): LoginDAO

    companion object {
        private lateinit var INSTANCE: LoginDataBase

        fun getDataBase(context: Context): LoginDataBase {
            if (!::INSTANCE.isInitialized) {
                synchronized(LoginDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context, LoginDataBase::class.java, "guestdb")
                        .addMigrations(MIGRATION_1_2)
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }

        private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("DELETE FROM Guest")
            }

        }
    }
}