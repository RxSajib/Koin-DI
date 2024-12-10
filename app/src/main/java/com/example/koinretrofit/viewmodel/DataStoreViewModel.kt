package com.example.koinretrofit.viewmodel

import androidx.lifecycle.ViewModel
import com.example.koinretrofit.ui.datastorerep.DataStoreRep
import kotlinx.coroutines.flow.Flow

class DataStoreViewModel constructor(
    private val dataStoreRep: DataStoreRep
) : ViewModel() {

    fun getIntData(key : String) : Flow<Int> = dataStoreRep.getInt(key = key)
}