package com.example.buylist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.buylist.listener.Listener
import com.example.buylist.model.ProductsModel
import com.example.buylist.repository.ProductsRepository
import kotlinx.coroutines.launch
import java.util.Collections.list

class AllProductsViewModel(application: Application) : AndroidViewModel(application){

    private val productsRepository = ProductsRepository(application.applicationContext)

    private val _product = MutableLiveData <List<ProductsModel>>()
    val product : LiveData <List<ProductsModel>> = _product



    fun delete(id: Int){
        productsRepository.deleteList(id)
    }
    fun getAll(){
        _product.value = productsRepository.getAll()
    }

    fun status(id: Int, complete: Boolean) {
        val productToUpdate = product.value?.find { it.id == id }
        productToUpdate?.let {
            it.complete = complete
            productsRepository.updateProducts(it)
            _product.value = product.value // Notifica as alterações para o fragmento
        }
    }

    fun getAllProducts(selectedListId: Int): LiveData<List<ProductsModel>> {
        return productsRepository.getAllProducts(selectedListId)
    }
}