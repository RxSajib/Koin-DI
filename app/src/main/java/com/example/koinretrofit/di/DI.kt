package com.example.koinretrofit.di

import com.example.koinretrofit.data.datamanager.DataManager.BASEURL
import com.example.koinretrofit.data.model.datastore.DataStoreModel
import com.example.koinretrofit.datastore.DataStoreImp
import com.example.koinretrofit.datastore.MyDataStore
import com.example.koinretrofit.network.API
import com.example.koinretrofit.ui.adapter.ItemAdapter
import com.example.koinretrofit.ui.datastore.GetBoolData
import com.example.koinretrofit.ui.datastore.GetIntData
import com.example.koinretrofit.ui.datastore.GetStringData
import com.example.koinretrofit.ui.datastore.SaveBoolData
import com.example.koinretrofit.ui.datastore.SaveIntData
import com.example.koinretrofit.ui.datastore.SaveStringData
import com.example.koinretrofit.ui.datastorerep.DataStoreRep
import com.example.koinretrofit.ui.repository.DatabaseRep
import com.example.koinretrofit.ui.repository.Post
import com.example.koinretrofit.viewmodel.DataStoreViewModel
import com.example.koinretrofit.viewmodel.DatabaseViewModel
import com.example.koinretrofit.viewmodel.MyViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val my_module = module {

    single {
        Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
      get<Retrofit>().create(API::class.java)
    }

    factory {
        Post(get())
    }

    factory {
        ItemAdapter()
    }

    viewModel {
        MyViewModel(get())
    }
}

val room_module = module {

    single {
        provideDatabase(androidContext())
    }

   single {
       provideDao(get())
   }

    factory {
        DatabaseRep(
            get()
        )
    }

    viewModel {
        DatabaseViewModel(get())
    }
}

val dataStore_Module = module {

    single<MyDataStore> {
        DataStoreImp(context = androidContext())
    }

    factory {
        SaveStringData(get())
    }
    factory {
        SaveIntData(get())
    }
    factory {
        SaveBoolData(get())
    }
    factory {
        GetStringData(get())
    }
    factory {
        GetIntData(get())
    }
    factory {
        GetBoolData(get())
    }

    single {
        DataStoreModel(
            saveStringData = get(),
            saveIntData = get(),
            saveBoolData = get(),
            getStringData = get(),
            getIntData = get(),
            getBoolData = get()
        )
    }

    factory {
        DataStoreRep(
            saveStringData = get(),
            saveIntData = get(),
            saveBoolData = get(),
            getStringData = get(),
            getBoolData = get(),
            getIntData = get()
        )
    }

    viewModel {
        DataStoreViewModel(
            dataStoreRep = get()
        )
    }

}