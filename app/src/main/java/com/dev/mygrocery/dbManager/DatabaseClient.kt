package com.dev.mygrocery.dbManager

import android.content.Context
import androidx.room.Room

class DatabaseClient private constructor(private val mCtx: Context) {

    val appDatabase: AppDatabase = Room.databaseBuilder(mCtx, AppDatabase::class.java, "MyGrocery").build()

    companion object{

        private var mInstance : DatabaseClient? =  null


        @Synchronized
        fun getInstance(mCtx: Context) :DatabaseClient?{

            if(mInstance == null){
                mInstance = DatabaseClient(mCtx)
            }

            return mInstance
        }
    }

}