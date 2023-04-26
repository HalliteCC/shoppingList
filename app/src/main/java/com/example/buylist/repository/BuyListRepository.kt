package com.example.buylist.repository

import android.content.Context
import com.example.buylist.model.BuyListModel


class BuyListRepository(context: Context) {

    private val loginDataBase = LoginDataBase.getDataBase(context).buyListDao()

    fun insertList(buyList: BuyListModel): Boolean {
        return loginDataBase.insertList(buyList) > 0
    }

    fun uptadeList(buyList: BuyListModel): Boolean {
        return loginDataBase.updateList(buyList) > 0
    }

    fun deleteList(id: Int) {
        val list = get(id)
    }

    fun get(id: Int): BuyListModel {
        return loginDataBase.get(id)
    }

    fun getAll(): List<BuyListModel>{
        return loginDataBase.getList()
    }
}