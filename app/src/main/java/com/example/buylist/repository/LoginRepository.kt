package com.example.buylist.repository

import android.content.Context
import com.example.buylist.R
import com.example.buylist.listener.Listener
import com.example.buylist.model.LoginModel

class LoginRepository(context: Context) : BaseRepository(context) {

    private val loginDataBase = LoginDataBase.getDataBase(context).loginDao()

    fun insert(login: LoginModel, listener: Listener <LoginModel>): Boolean {
        return loginDataBase.insert(login) > 0
    }


    fun get(email: String, password: String): LoginModel {
        return loginDataBase.getUser(email, password)
    }

}