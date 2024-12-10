package com.example.koinretrofit.ui.repository

import com.example.koinretrofit.data.model.PostModel
import com.example.koinretrofit.network.API
import com.example.koinretrofit.utils.NetworkResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


private const val TAG = "Post"
class Post constructor(
    private val api: API
) {

    private val mutableStateFlow = MutableStateFlow<NetworkResult<PostModel>>(NetworkResult.Empty())
    val stateFlow : StateFlow<NetworkResult<PostModel>> get() = mutableStateFlow


    suspend fun getPOst(){
        try {
            mutableStateFlow.emit(NetworkResult.Loading())
            val response  =api.getPost()
            if(response.isSuccessful && response.body() != null){
                mutableStateFlow.emit(NetworkResult.Success(response.body()!!))
            }else {
                mutableStateFlow.emit(NetworkResult.Error("Something went wrong"))
            }
        }catch (e : Exception){
            mutableStateFlow.emit(NetworkResult.Error("Something went wrong"))
        }
    }
}
