package com.example.buylist.repository.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.buylist.model.ProductsModel

@Dao
interface ProductsDAO {

    @Insert
    fun insertProduct(productsList: ProductsModel): Long

    @Delete
    fun deleteProduct(productsList: ProductsModel)

    @Update
    fun updateProduct (productsList: ProductsModel): Int

    @Query("SELECT * FROM productsList WHERE id = :id")
    fun get(id: Int): ProductsModel

    @Query("SELECT * FROM productsList")
    fun getAllProduct(): List<ProductsModel>

    @Query("SELECT * FROM productsList WHERE listId = :selectedListId")
    fun getAllProductsByListId(selectedListId: Int): List<ProductsModel>
}