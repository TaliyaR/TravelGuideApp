package com.example.travelguide.data.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.travelguide.presentation.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory
    ): ViewModelProvider.Factory
}
