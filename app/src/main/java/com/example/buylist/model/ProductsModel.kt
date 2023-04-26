package com.example.buylist.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "products")
class ProductsModel {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0

    @ColumnInfo(name = "products")
    var products: String = ""

    @ColumnInfo(name = "products")
    var price: String = ""

    @ColumnInfo(name = "products")
    var quatity: String = ""

    @ColumnInfo(name = "products")
    var priority: String = ""
}