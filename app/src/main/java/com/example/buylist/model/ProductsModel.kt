package com.example.buylist.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "productsList")
class ProductsModel {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0

    @ColumnInfo(name = "products")
    var products: String = ""

    @ColumnInfo(name = "price")
    var price: Double = 0.0

    @ColumnInfo(name = "quatity")
    var quatity: String = ""

    @ColumnInfo(name = "priority")
    var priority: String = ""
}