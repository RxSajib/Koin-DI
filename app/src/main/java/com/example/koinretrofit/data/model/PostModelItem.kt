package com.example.koinretrofit.data.model


import androidx.annotation.Keep

@Keep
data class PostModelItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)