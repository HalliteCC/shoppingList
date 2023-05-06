package com.example.buylist.listener

interface BuyListListener {

    //Click para edição
    fun onListClick(id: Int)

    //Remoção
    fun onDeleteClick(id: Int)

}