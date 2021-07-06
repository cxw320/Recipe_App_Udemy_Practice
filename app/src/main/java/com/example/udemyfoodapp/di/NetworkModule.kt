package com.example.udemyfoodapp.di

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

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
    ): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()

    }

    //to create FoodRecipesApi, need to create a retrofit instance
    @Singleton
    @Provides
    fun provideApiService(retrofit: RetroFit):FoodRecipesApi{

        return retrofit.create(FoodRecipesApi::class.java)

    }

}