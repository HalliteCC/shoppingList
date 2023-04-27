package com.example.buylist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.buylist.model.BuyListModel
import com.example.buylist.repository.BuyListRepository

class BuyListViewModel(application: Application): AndroidViewModel(application) {

    private val buyListRepository = BuyListRepository(application)

    private val buyListModel = MutableLiveData<BuyListModel>()
    val buyList: LiveData<BuyListModel> = buyListModel

    fun get(id: Int){
        buyListModel.value = buyListRepository.get(id)
    }

    fun insert(buyList: BuyListModel){
        buyListRepository.insertList(buyList)
    }

    fun update(buyList: BuyListModel){
        buyListRepository.uptadeList(buyList)
    }

    fun delete(id: Int){
        buyListRepository.deleteList(id)
    }
}