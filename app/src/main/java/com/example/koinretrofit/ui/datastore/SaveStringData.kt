package com.example.koinretrofit.ui.datastore

import com.example.koinretrofit.datastore.MyDataStore

class SaveStringData (
    private val dataStore: MyDataStore
) {

    suspend operator fun invoke(key : String, value : String) = dataStore.saveStringData(key = key, value = value)
}