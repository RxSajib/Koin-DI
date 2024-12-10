package com.example.koinretrofit.data.model.bookmark

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BookMarkDB")
data class BookMarkModel(
    @PrimaryKey(autoGenerate = false)
    val id : Int,
    val title : String,
    val details : String
)
