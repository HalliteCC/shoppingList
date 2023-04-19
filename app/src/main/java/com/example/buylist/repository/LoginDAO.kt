package com.example.buylist.repository

import androidx.room.*
import com.example.buylist.model.LoginModel

@Dao
interface LoginDAO {

    @Insert
    fun insert(login: LoginModel): Long


    @Query("SELECT * FROM login WHERE email = :email AND password = :password")
    fun getUser(email: String, password: String): LoginModel
}