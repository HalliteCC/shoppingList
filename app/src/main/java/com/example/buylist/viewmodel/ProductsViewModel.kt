package com.example.buylist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.buylist.model.ProductsModel
import com.example.buylist.repository.ProductsRepository

class ProductsViewModel(application: Application) : AndroidViewModel(application) {

    private val productsRepository = ProductsRepository(application.applicationContext)

    private val _productSave = MutableLiveData<ProductsModel>()
    var productSave: LiveData<ProductsModel> = _productSave

    fun get(id: Int) {
        _productSave.value = productsRepository.get(id)
    }

    fun insetProduct(products: ProductsModel) {
        productsRepository.insertProduct(products)
    }

    fun updateProduct(products: ProductsModel) {
        productsRepository.updateProducts(products)
    }
}