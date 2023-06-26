package com.example.buylist.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.buylist.model.ProductsModel

class ProductsRepository(context: Context) {

    private val loginDataBase = LoginDataBase.getDataBase(context).productsDao()

    fun insertProduct(products: ProductsModel): Boolean {
        return loginDataBase.insertProduct(products) > 0
    }

    fun updateProducts(products: ProductsModel): Boolean {
        return loginDataBase.updateProduct(products) > 0
    }

    fun deleteList(id: Int) {
        val list = get(id)
        loginDataBase.deleteProduct(list)
    }

    fun get(id: Int): ProductsModel {
        return loginDataBase.get(id)
    }

    fun getAll(): List<ProductsModel>{
        return loginDataBase.getAllProduct()
    }

    fun updateProductStatus(id: Int, complete: Boolean) {
        val product = get(id)
        product.complete = complete
        updateProducts(product)
    }

    fun getAllProducts(selectedListId: Int): LiveData<List<ProductsModel>> {
        return loginDataBase.getAllProductsByListId(selectedListId)
    }
}