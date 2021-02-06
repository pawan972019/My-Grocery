package com.dev.mygrocery.dbManager

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [GroceryListEntity::class, GroceryEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun groceryDao(): GroceryDao

    abstract fun getGroceryListDao(): GroceryListDao
}