package com.dev.mygrocery.dbManager

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DataDao {

    @Insert
    fun insertData(data: GroceryDataList)

    @Query("SELECT * FROM GroceryDataList")
    fun getData(): List<GroceryDataList>
}