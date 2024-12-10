package com.example.koinretrofit.datastore

import kotlinx.coroutines.flow.Flow

interface MyDataStore {

    suspend fun saveStringData(key : String, value : String)
    suspend fun saveIntData(key : String, value : Int)
    suspend fun saveBoolData(key : String, value : Boolean)

    fun getStringData(key : String) : Flow<String>
    fun getIntData(key : String) : Flow<Int>
    fun getBoolData(key : String) : Flow<Boolean>
}