package com.example.koinretrofit.network

import com.example.koinretrofit.data.model.PostModel
import retrofit2.Response
import retrofit2.http.GET

interface API {

    @GET("posts")
    suspend fun getPost() : Response<PostModel>

}