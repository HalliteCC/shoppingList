package com.example.buylist.repository.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.buylist.model.BuyListModel

@Dao
interface BuyListDao {

    @Insert
    fun insertList(buyList: BuyListModel): Long

    @Delete
    fun deleteList(BuyList: BuyListModel)

    @Update
    fun updateList (BuyList: BuyListModel): Int

    @Query("SELECT * FROM BuyList WHERE id = :id")
    fun get(id: Int): BuyListModel

    @Query("SELECT * FROM BuyList")
    fun getList(): List<BuyListModel>

}