package com.example.koinretrofit.ui.repository

import com.example.koinretrofit.data.model.bookmark.BookMarkModel
import com.example.koinretrofit.utils.db.RoomDao
import kotlinx.coroutines.flow.Flow

class DatabaseRep constructor(
    private val dao: RoomDao
) {

    fun getListOfItem() : Flow<List<BookMarkModel>> = dao.getBookMark()

}