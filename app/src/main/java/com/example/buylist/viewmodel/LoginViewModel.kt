package com.example.buylist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.buylist.R
import com.example.buylist.constants.BuyConstants
import com.example.buylist.listener.Listener
import com.example.buylist.model.LoginModel
import com.example.buylist.model.ValidationModel
import com.example.buylist.repository.LoginRepository
import com.example.buylist.repository.SecurityPreferences

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val loginRepository = LoginRepository(application.applicationContext)
    private val securityPrefereces = SecurityPreferences(application.applicationContext)

    private val _login = MutableLiveData<ValidationModel>()
    val login: LiveData<ValidationModel> = _login



    fun doLogin(email: String, password: String){
        if (email.isBlank() || password.isBlank()) {
            _login.value =
                ValidationModel(getApplication<Application>().applicationContext.getString(R.string.fill_all_fields))
            return
        }

        loginRepository.login(email, password, object : Listener<LoginModel>{
            override fun onSuccess(result: LoginModel) {
                securityPrefereces.store(BuyConstants.LOGIN.KEY_EMAIL, email)
                securityPrefereces.store(BuyConstants.LOGIN.KEY_PASS, password)

                _login.value = ValidationModel()
            }

            override fun onFaliure(message: String) {
                _login.value = ValidationModel((getApplication<Application>().applicationContext.getString(R.string.ERROR_LOGIN)))
            }

        })

    }

    fun verifyAuthentication(){
        val getID = securityPrefereces.get(BuyConstants.LOGIN.ID)
        val getEmail = securityPrefereces.get(BuyConstants.LOGIN.KEY_EMAIL)

        if (getEmail != ""){
            _login.value = ValidationModel()
        }
    }
}