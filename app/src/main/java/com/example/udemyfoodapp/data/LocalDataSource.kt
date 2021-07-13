package com.example.udemyfoodapp.data

import com.example.udemyfoodapp.data.database.RecipesDao
import com.example.udemyfoodapp.data.database.RecipesEntity
import java.util.concurrent.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val recipesDao: RecipesDao
){

    fun readDataBase(): Flow<List<RecipesEntity>> {
        return recipesDao.readRecipes()
    }

    suspend fun insertRecipes(recipesEntity: RecipesEntity){
        recipesDao.insertRecipes(recipesEntity)
    }

}