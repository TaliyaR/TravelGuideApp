package com.example.travelguide.ui.placesList.di.module

import com.example.travelguide.data.PlaceService
import com.example.travelguide.ui.placesList.data.PlacesListRepository
import com.example.travelguide.ui.placesList.di.scope.PlacesListScope
import com.example.travelguide.ui.placesList.domain.PlacesListInteractor
import com.example.travelguide.ui.placesList.presentation.list.PlacesListViewModel
import dagger.Module
import dagger.Provides

@Module
class PlacesListModule {

    @Provides
    @PlacesListScope
    fun providePlacesViewModel(interactor: PlacesListInteractor): PlacesListViewModel =
        PlacesListViewModel(
            interactor
        )

    @Provides
    @PlacesListScope
    fun providePlacesListInteractor(repository: PlacesListRepository): PlacesListInteractor =
        PlacesListInteractor(repository)

    @Provides
    @PlacesListScope
    fun providePlacesListRepository(service: PlaceService): PlacesListRepository =
        PlacesListRepository(service)
}
