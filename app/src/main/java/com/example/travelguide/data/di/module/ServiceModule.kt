package com.example.travelguide.data.di.module

import com.example.travelguide.data.PlaceService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): PlaceService =
        retrofit.create(PlaceService::class.java)
}
