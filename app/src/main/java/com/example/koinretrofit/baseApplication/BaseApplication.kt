package com.example.koinretrofit.baseApplication

import android.app.Application
import com.example.koinretrofit.di.dataStore_Module
import com.example.koinretrofit.di.my_module
import com.example.koinretrofit.di.room_module
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            printLogger()
            androidContext(this@BaseApplication)
            modules(
                modules = listOf( room_module, my_module, dataStore_Module)
            )
        }
    }
}
//