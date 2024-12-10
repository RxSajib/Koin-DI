package com.example.koinretrofit.utils.db

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.koinretrofit.data.model.bookmark.BookMarkModel
import kotlinx.coroutines.flow.Flow

@Dao
interface RoomDao {

    @Query("SELECT * FROM BookMarkDB")
    fun getBookMark() : Flow<List<BookMarkModel>>

    @Upsert
    fun saveBookMark(bookMarkModel: BookMarkModel)

}