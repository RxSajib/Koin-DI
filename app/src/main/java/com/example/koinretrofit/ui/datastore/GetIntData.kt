package com.example.koinretrofit.ui.datastore

import com.example.koinretrofit.datastore.MyDataStore

class GetIntData constructor(
    private val dataStore: MyDataStore
) {

    operator fun invoke(key : String) = dataStore.getIntData(key = key)
}