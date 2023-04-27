package com.example.buylist.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "BuyList")
class BuyListModel {

    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0

    @ColumnInfo(name = "listName")
    var listName: String = ""

    @ColumnInfo(name = "complete")
    var complete: Boolean = false

}