package com.example.buylist.listener

interface Listener <S> {
    fun onSuccess(result: S)
    fun onFaliure(message: String)
}