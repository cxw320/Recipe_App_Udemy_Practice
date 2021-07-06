package com.example.udemyfoodapp.data

import dagger.hilt.android.scopes.ActivityRetainedScoped


@ActivityRetainedScoped
class Repository @Inject constructor(
    remoteDataSource: RemoteDataSource
){
    val remote = remoteDataSource

}