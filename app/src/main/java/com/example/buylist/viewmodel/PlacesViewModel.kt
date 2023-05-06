package com.example.buylist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.buylist.model.BuyListModel
import com.example.buylist.repository.BuyListRepository

class PlacesViewModel(application: Application) : AndroidViewModel(application) {

    private val buyListRepository = BuyListRepository(application.applicationContext)

    private val _place = MutableLiveData<BuyListModel>()
    val place: LiveData<BuyListModel> = _place

    fun get(id: Int){
        _place.value = buyListRepository.get(id)
    }

    fun insert(buyList: BuyListModel) {
        buyListRepository.insertList(buyList)
    }

    fun update(buyList: BuyListModel) {
        buyListRepository.updateList(buyList)
    }
}