package com.dev.mygrocery.dbManager

import androidx.annotation.ColorLong
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class GroceryEntity {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo(name = "listName")
    var listName: String? = null

    @ColumnInfo(name = "itemName")
    var itemName: String? = null

    @ColumnInfo(name = "finished")
    var isFinished: Boolean = false
}




