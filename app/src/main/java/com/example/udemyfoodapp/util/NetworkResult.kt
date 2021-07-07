package com.example.udemyfoodapp.util
//2 parameters: 1 data from api and 2 represents a message
// generics for data

sealed class NetworkResult<T>(
    val data: T? = null,
    val message: String? = null
){

    class Success<T>(data:T?): NetworkResult<T>(data)
    class Error<T>(message: String?, data: T? = null): NetworkResult<T>(data, message)
    class Loading<T>: NetworkResult<T>()

}