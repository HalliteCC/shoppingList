package com.example.buylist.repository

import android.content.Context
import com.example.buylist.R
import com.example.buylist.listener.Listener
import com.example.buylist.model.LoginModel

class LoginRepository(context: Context) : BaseRepository(context) {

    private val loginDataBase = LoginDataBase.getDataBase(context).loginDao()

    fun insert(login: LoginModel, listener: Listener <LoginModel>) {
        if(!isConectionAvaliable()){
            listener.onFaliure(context.getString(R.string.ERROR_INTERNET_CONNECTION))
            return
        }else {
            loginDataBase.insert(login) > 0
            listener.onSuccess(login)
        }
    }


    fun get(email: String, password: String): LoginModel {
        return loginDataBase.getUser(email, password)
    }

}