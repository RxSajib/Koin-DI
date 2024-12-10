package com.example.koinretrofit.data.model.datastore

import com.example.koinretrofit.ui.datastore.GetBoolData
import com.example.koinretrofit.ui.datastore.GetIntData
import com.example.koinretrofit.ui.datastore.GetStringData
import com.example.koinretrofit.ui.datastore.SaveBoolData
import com.example.koinretrofit.ui.datastore.SaveIntData
import com.example.koinretrofit.ui.datastore.SaveStringData

data class DataStoreModel(
    val saveStringData: SaveStringData,
    val saveIntData: SaveIntData,
    val saveBoolData: SaveBoolData,
    val getStringData: GetStringData,
    val getIntData: GetIntData,
    val getBoolData: GetBoolData

)