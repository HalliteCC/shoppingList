package com.example.buylist.listener

interface BuyListListener {

    //Click para edição
    fun onListClick(id: Int)

    //Remoção
    fun onDeleteClick(id: Int)

    //Completar tarefa
    fun onCompleteClick(id: Int)

    //Descompletar Tarefa
    fun onUndoClick(id: Int)
}