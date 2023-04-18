package com.example.buylist.repository

import android.content.Context

class LoginRepository(context: Context) {
private val loginDataBase = LoginDataBase.getDataBase(context).loginDao()
}