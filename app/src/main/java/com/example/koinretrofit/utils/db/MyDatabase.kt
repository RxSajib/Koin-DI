package com.example.koinretrofit.utils.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.koinretrofit.data.model.bookmark.BookMarkModel

@Database(entities = [BookMarkModel::class], version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {

    abstract val dao : RoomDao

}