package com.example.udemyfoodapp.data.network
import com.example.udemyfoodapp.models.FoodRecipe
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface FoodRecipesApi {

    @GET("/recipes/complexSearch")
    suspend fun getRecipes(
        @QueryMap queries: Map<String, String>
    ): Response<FoodRecipe>  // wrapped in a response class

    // function takes query in parameters and specify a query map
    // specify the query inside one hash map

    // this function will run kotlin co-routines

}
