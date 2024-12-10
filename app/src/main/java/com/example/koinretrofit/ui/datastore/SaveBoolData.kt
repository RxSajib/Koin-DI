package com.example.koinretrofit.ui.datastore

import com.example.koinretrofit.datastore.MyDataStore

class SaveBoolData constructor(
    private val myDataStore: MyDataStore
) {

    suspend operator fun invoke(key : String, value : Boolean) = myDataStore.saveBoolData(key = key, value = value)
}