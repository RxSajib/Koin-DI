package com.example.koinretrofit.ui.datastore

import com.example.koinretrofit.datastore.MyDataStore

class GetStringData constructor(
    private val dataStore: MyDataStore
) {

    operator fun invoke(key : String) = dataStore.getStringData(key = key)
}