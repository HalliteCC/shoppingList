package com.example.buylist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.buylist.model.BuyListModel
import com.example.buylist.model.ValidationModel
import com.example.buylist.repository.BuyListRepository

class AllPlacesViewModel(application: Application) : AndroidViewModel(application) {

    private val buyListRepository = BuyListRepository(application.applicationContext)


    private val _delete = MutableLiveData<ValidationModel>()
    val delete: LiveData<ValidationModel> = _delete

    private val _buy = MutableLiveData<List<BuyListModel>>()
    val buy: LiveData<List<BuyListModel>> = _buy


    fun getAll(){
        _buy.value = buyListRepository.getAll()
    }

    fun delete(id: Int){
        buyListRepository.deleteList(id)
    }

    fun spinner(): List<BuyListModel>{
        return buyListRepository.getAll()
    }

}

