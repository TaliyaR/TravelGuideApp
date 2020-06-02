package com.example.travelguide.ui.placesList.di.module

import androidx.lifecycle.ViewModel
import com.example.travelguide.app.di.module.ViewModelModule
import com.example.travelguide.app.di.scope.ViewModelKey
import com.example.travelguide.ui.placesList.presentation.list.PlacesListViewModel
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
