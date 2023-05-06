package com.example.buylist.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.buylist.model.BuyListModel
import com.example.buylist.model.LoginModel
import com.example.buylist.model.ProductsModel
import com.example.buylist.repository.dao.BuyListDao
import com.example.buylist.repository.dao.LoginDAO
import com.example.buylist.repository.dao.ProductsDAO

@Database(entities = [LoginModel::class, BuyListModel::class, ProductsModel::class], version = 1)
abstract class LoginDataBase : RoomDatabase() {

    abstract fun loginDao(): LoginDAO
    abstract fun buyListDao(): BuyListDao
    abstract fun productsDao(): ProductsDAO

    companion object {
        private lateinit var INSTANCE: LoginDataBase

        fun getDataBase(context: Context): LoginDataBase {
            if (!::INSTANCE.isInitialized) {
                synchronized(LoginDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context, LoginDataBase::class.java, "buydb")
                        .addMigrations(MIGRATION_LOGIN_1_2)
                        .addMigrations(MIGRATION_BUYLIST_1_2)
                        .addMigrations(MIGRATION_PRODUCTS_1_2)
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
        private val MIGRATION_LOGIN_1_2: Migration = object : Migration(1, 2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("DELETE FROM Login")
            }
        }
        private val MIGRATION_BUYLIST_1_2: Migration = object : Migration(1, 2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("DELETE FROM BuyList")
            }
        }
        private val MIGRATION_PRODUCTS_1_2: Migration = object : Migration(1, 2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("DELETE FROM productsList")
            }
        }

    }
}