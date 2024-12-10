package com.example.koinretrofit.di

import android.content.Context
import androidx.room.Room
import com.example.koinretrofit.utils.db.MyDatabase
import com.example.koinretrofit.utils.db.RoomDao

fun provideDatabase(context: Context) : MyDatabase {
    return Room.databaseBuilder(context, MyDatabase::class.java, "DB")
        .fallbackToDestructiveMigration().build()
}

fun provideDao(myDatabase: MyDatabase) : RoomDao{
    return myDatabase.dao
}