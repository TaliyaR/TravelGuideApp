package com.example.travelguide.ui.placesList.di.module

import androidx.lifecycle.ViewModel
import com.example.travelguide.app.di.module.ViewModelModule
import com.example.travelguide.app.di.scope.ViewModelKey
import com.example.travelguide.ui.placesList.presentation.details.PlaceDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelModule::class])
abstract class PlacesDetailsViewModelModule {

    @IntoMap
    @Binds
    @ViewModelKey(PlaceDetailsViewModel::class)
    abstract fun bindPlaceDetailsViewModel(
        placeDetailsViewModel: PlaceDetailsViewModel
    ): ViewModel
}
