package com.example.buylist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.buylist.constants.BuyConstants
import com.example.buylist.listener.Listener
import com.example.buylist.model.LoginModel
import com.example.buylist.model.ValidationModel
import com.example.buylist.repository.LoginRepository
import com.example.buylist.repository.SecurityPreferences

class RegisterViewModel(application: Application) : AndroidViewModel(application) {

    private val loginRepository = LoginRepository(application.applicationContext)
    private val securityPrefereces = SecurityPreferences(application.applicationContext)


    private val _register = MutableLiveData <ValidationModel>()
    val register: LiveData <ValidationModel> = _register


    fun get(email: String, password: String): LoginModel {
        return loginRepository.get(email, password)
    }

    fun create(name: String, email: String, password: String){
        loginRepository.insert(LoginModel(name = name, email = email, password = password),
            object : Listener<LoginModel> {
                override fun onSuccess(result: LoginModel) {
                    securityPrefereces.store(BuyConstants.LOGIN.KEY_EMAIL, email)

                    _register.value = ValidationModel()

                }

                override fun onFaliure(message: String) {
                    _register.value = ValidationModel(message)
                }
            })
    }
}