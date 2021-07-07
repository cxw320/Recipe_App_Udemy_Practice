package com.example.udemyfoodapp.di
import dagger.hilt.android.components.SingletonComponent
import com.example.udemyfoodapp.data.network.FoodRecipesApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

import com.example.udemyfoodapp.util.Constants.Companion.BASE_URL
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit

import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    //need to create httpClient and converter factory for retrofit instance

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }


    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory{
        return GsonConverterFactory.create()
    }


    //we are telling hilt library which class we want to inject later
    //have to specify how to provide retrofit

    //using application scope
    //retrofit is an external library so we have to use Provides

    @Singleton
    @Provides
    fun provideRetrofitInstance(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()

    }

    //to create FoodRecipesApi, need to create a retrofit instance
    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): FoodRecipesApi {

        return retrofit.create(FoodRecipesApi::class.java)

    }

}