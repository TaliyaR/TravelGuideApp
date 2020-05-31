package com.example.travelguide.placesList.di.module

import androidx.lifecycle.ViewModel
import com.example.travelguide.data.di.module.ViewModelModule
import com.example.travelguide.data.di.scope.ViewModelKey
import com.example.travelguide.placesList.presentation.list.PlacesListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelModule::class])
abstract class PlacesListViewModelModule{

    @IntoMap
    @Binds
    @ViewModelKey(PlacesListViewModel::class)
    abstract fun bindPlacesListViewModel(
        placesListViewModel: PlacesListViewModel
    ): ViewModel
}
