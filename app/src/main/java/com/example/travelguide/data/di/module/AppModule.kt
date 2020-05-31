package com.example.travelguide.data.di.module

import android.app.Application
import android.content.Context
import com.example.travelguide.app.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(app: App) : Context = app.applicationContext
//    fun provideContext(app: Application) : Context = app.applicationContext
}
