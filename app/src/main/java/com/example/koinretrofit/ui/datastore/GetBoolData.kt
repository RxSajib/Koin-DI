package com.example.koinretrofit.ui.datastore

import com.example.koinretrofit.datastore.MyDataStore

class GetBoolData constructor(
    private val myDataStore: MyDataStore
) {

    operator fun invoke(key : String) = myDataStore.getBoolData(key = key)
}