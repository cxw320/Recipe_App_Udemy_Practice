package com.example.udemyfoodapp.viewmodels

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel

class RecipesViewModel @ViewModelInject constructor(
    application: Application,
    private val dataStoreREpository: DataStoreRepository
): AndroidViewModel(application){



}