package com.dev.mygrocery.dbManager

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = arrayOf(GroceryDataList::class), version = 1)
abstract class DataDatabase : RoomDatabase() {

    abstract fun dataDao(): DataDao

    companion object {

        @Volatile
        private var INSTANCE: DataDatabase? = null

        fun getInstance(context: Context): DataDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                DataDatabase::class.java, "Sample.db"
            ).build()

       // val PREPOPULATE_DATA = GroceryDataList(lin"1", "val")
    }
}