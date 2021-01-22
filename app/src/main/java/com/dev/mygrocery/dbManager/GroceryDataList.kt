package com.dev.mygrocery.dbManager

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "groceryDataList")
data class GroceryDataList(@PrimaryKey(autoGenerate = true) var _id: Int = -1,
                           @ColumnInfo(name = "list_name") var list_name: String?,
                           @ColumnInfo(name = "value") var value: Long?)