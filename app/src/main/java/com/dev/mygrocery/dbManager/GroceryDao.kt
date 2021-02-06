package com.dev.mygrocery.dbManager

import androidx.room.*

@Dao
interface GroceryDao {


    @get:Query("SELECT * FROM groceryentity")
    val all: List<GroceryEntity?>?

    @Insert
    fun insert(task: GroceryEntity?)

    @Delete
    fun delete(task: GroceryEntity?)

    @Update
    fun update(task: GroceryEntity?)

}