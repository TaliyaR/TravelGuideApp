package com.example.travelguide.app.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.travelguide.data.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory
    ): ViewModelProvider.Factory
}
