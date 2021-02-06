package com.dev.mygrocery.dbManager

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface GroceryListDao {

    @get:Query("SELECT * FROM grocerylistentity")
    val all: List<GroceryListEntity?>?

    @Insert
    fun insertListName(groceryListEntity: GroceryListEntity?)

    @Update
    fun updateListName(groceryListEntity: GroceryListEntity?)


}