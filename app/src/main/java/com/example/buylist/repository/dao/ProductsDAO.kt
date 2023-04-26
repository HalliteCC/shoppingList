package com.example.buylist.repository.dao

import androidx.room.*
import com.example.buylist.model.BuyListModel
import com.example.buylist.model.ProductsModel

@Dao
interface ProductsDAO {

    @Insert
    fun insertProduct(products: ProductsModel): Long

    @Delete
    fun deleteProduct(products: ProductsModel)

    @Update
    fun updateProduct (products: ProductsModel): Int

    @Query("SELECT * FROM products WHERE id = :id")
    fun get(id: Int): ProductsModel

    @Query("SELECT * FROM products")
    fun getAllProduct(): List<ProductsModel>
}