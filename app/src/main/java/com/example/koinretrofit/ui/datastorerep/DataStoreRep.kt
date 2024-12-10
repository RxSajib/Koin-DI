package com.example.koinretrofit.ui.datastorerep

import com.example.koinretrofit.ui.datastore.GetBoolData
import com.example.koinretrofit.ui.datastore.GetIntData
import com.example.koinretrofit.ui.datastore.GetStringData
import com.example.koinretrofit.ui.datastore.SaveBoolData
import com.example.koinretrofit.ui.datastore.SaveIntData
import com.example.koinretrofit.ui.datastore.SaveStringData
import kotlinx.coroutines.flow.Flow

class DataStoreRep constructor(
    private val saveStringData: SaveStringData,
    private val saveIntData: SaveIntData,
    private val saveBoolData: SaveBoolData,
    private val getStringData: GetStringData,
    private val getIntData: GetIntData,
    private val getBoolData: GetBoolData
) {

    suspend fun saveString(key: String, value: String) = saveStringData(key = key, value = value)

    suspend fun saveInt(key: String, value: Int) = saveIntData(key = key, value = value)

    suspend fun saveBool(key: String, value: Boolean) = saveBoolData(key = key, value = value)


    fun getString(key: String): Flow<String> = getStringData(key = key)

    fun getInt(key: String): Flow<Int> = getIntData(key = key)

    fun getBool(key: String): Flow<Boolean> = getBoolData(key = key)
}