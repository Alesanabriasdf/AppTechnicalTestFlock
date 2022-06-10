package com.example.apptechnicaltestflock.di

import com.example.apptechnicaltestflock.apiservice.AppConstants
import com.example.apptechnicaltestflock.apiservice.getlistcocktails.CocktailsApiService
import com.example.apptechnicaltestflock.apiservice.getlistingredients.IngredientsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideListIngredientsApiService(retrofit: Retrofit): IngredientsApiService {
        return retrofit.create(IngredientsApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideListCocktailsApiService(retrofit: Retrofit): CocktailsApiService {
        return retrofit.create(CocktailsApiService::class.java)
    }
}