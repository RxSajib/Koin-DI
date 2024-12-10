package com.example.koinretrofit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.koinretrofit.data.model.PostModel
import com.example.koinretrofit.ui.repository.Post
import com.example.koinretrofit.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class MyViewModel constructor(
    private val post: Post
) : ViewModel() {

    val stateFlow : StateFlow<NetworkResult<PostModel>> get() = post.stateFlow

    fun getAllPost(){
        try {
            viewModelScope.launch(Dispatchers.IO) {
                post.getPOst()
            }
        }catch (e : Exception){
            e.printStackTrace()
        }
    }

    init {
        getAllPost()
    }
}
