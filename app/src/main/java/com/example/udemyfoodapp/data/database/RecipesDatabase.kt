package com.example.udemyfoodapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

class RecipesDatabase {

    @Database(
        entities = [RecipesEntity::class],
        version = 1,
        exportSchema = false
    )
    @TypeConverters(RecipesTypeConverter::class)
    abstract class RecipesDatabase: RoomDatabase(){
        abstract fun recipesDao(): RecipesDao
    }
}