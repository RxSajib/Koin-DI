package com.example.koinretrofit.ui.datastore

import com.example.koinretrofit.datastore.MyDataStore

class SaveIntData constructor(
    private val myDataStore: MyDataStore
) {

    suspend operator fun invoke (key : String, value : Int) = myDataStore.saveIntData(key = key, value = value)
}