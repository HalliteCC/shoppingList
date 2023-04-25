package com.example.buylist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.buylist.constants.BuyConstants
import com.example.buylist.repository.SecurityPreferences

class MainViewModel (application: Application) : AndroidViewModel(application){

    private var securityPreferences = SecurityPreferences(application.applicationContext)

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    fun logout(){
        securityPreferences.remove(BuyConstants.LOGIN.KEY_EMAIL)
    }

}