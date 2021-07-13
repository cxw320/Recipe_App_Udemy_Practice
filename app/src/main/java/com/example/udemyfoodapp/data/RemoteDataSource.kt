package com.example.udemyfoodapp.data

import com.example.udemyfoodapp.data.network.FoodRecipesApi
import com.example.udemyfoodapp.models.FoodRecipe
import retrofit2.Response
import javax.inject.Inject


//requests data from API, need to inject FoodAPi service


//by annotating the inject constructor and specifying the type we want to inject
// hilt will search for this specific type in the network module
// search for a function that returns FoodRecipesApi
//This will be how it knows to create an instance of FoodRecipesApi

class RemoteDataSource @Inject constructor(
    private val foodRecipesApi: FoodRecipesApi
) {
    suspend fun getRecipes(queries: Map<String,String>): Response<FoodRecipe>{
        return foodRecipesApi.getRecipes(queries)

    }
}