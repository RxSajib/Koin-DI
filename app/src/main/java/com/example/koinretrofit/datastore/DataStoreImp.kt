package com.example.koinretrofit.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreImp (val context: Context) : MyDataStore {

    private val Context.datastore : DataStore<Preferences> by preferencesDataStore(name = "DataStore")

    override suspend fun saveStringData(key: String, value: String) {
        context.datastore.edit { data ->
            data[stringPreferencesKey(name = key)] = value
        }
    }

    override suspend fun saveIntData(key: String, value: Int) {
        context.datastore.edit { data ->
            data[intPreferencesKey(name = key)] = value
        }
    }

    override suspend fun saveBoolData(key: String, value: Boolean) {
        context.datastore.edit { data ->
            data[booleanPreferencesKey(name = key)] = value
        }
    }

    override fun getStringData(key : String): Flow<String> {
        return context.datastore.data.map { data ->
            data[stringPreferencesKey(name = key)] ?: ""
        }
    }

    override fun getIntData(key : String): Flow<Int> {
        return context.datastore.data.map { data ->
            data[intPreferencesKey(name = key)] ?: 0
        }
    }

    override fun getBoolData(key : String): Flow<Boolean> {
        return context.datastore.data.map { data ->
            data[booleanPreferencesKey(name = key)] ?: false
        }
    }
}