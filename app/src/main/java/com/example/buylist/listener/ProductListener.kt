package com.example.buylist.listener

interface ProductListener {

    //Click para edição
    fun onClick(id: Int)

    //Click para remoção
    fun onDelete (id: Int)

    //Completar tarefa
    fun onCompleteClick(id: Int)

    //Descompletar Tarefa
    fun onUndoClick(id: Int)
}