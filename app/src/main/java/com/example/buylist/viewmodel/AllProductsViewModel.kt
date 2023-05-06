package com.example.buylist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.buylist.model.ProductsModel
import com.example.buylist.repository.ProductsRepository

class AllProductsViewModel(application: Application) : AndroidViewModel(application){

    private val productsRepository = ProductsRepository(application.applicationContext)

    private val _product = MutableLiveData <List<ProductsModel>>()
    val product : LiveData <List<ProductsModel>> = _product

    fun getAll(){
        _product.value = productsRepository.getAll()
    }
}