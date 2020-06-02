package com.example.travelguide.app.di.module

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
}
