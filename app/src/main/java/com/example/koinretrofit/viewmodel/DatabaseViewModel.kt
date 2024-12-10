package com.example.koinretrofit.viewmodel

import androidx.lifecycle.ViewModel
import com.example.koinretrofit.data.model.bookmark.BookMarkModel
import com.example.koinretrofit.ui.repository.DatabaseRep
import kotlinx.coroutines.flow.Flow

class DatabaseViewModel constructor(
    private val rep : DatabaseRep
) : ViewModel() {

    fun getBookMark() : Flow<List<BookMarkModel>> = rep.getListOfItem()
}