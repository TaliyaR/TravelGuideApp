package com.example.travelguide.placesList.di.module

import com.example.travelguide.data.PlaceService
import com.example.travelguide.placesList.data.PlacesListRepository
import com.example.travelguide.placesList.di.scope.PlacesDetailsScope
import com.example.travelguide.placesList.di.scope.PlacesListScope
import com.example.travelguide.placesList.domain.PlacesListInteractor
import com.example.travelguide.placesList.presentation.details.PlaceDetailsViewModel
import com.example.travelguide.placesList.presentation.list.PlacesListViewModel
import dagger.Module
import dagger.Provides

@Module
class PlaceDetailsModule {

    @Provides
    @PlacesDetailsScope
    fun providePlaceDetailsViewModel(interactor: PlacesListInteractor): PlaceDetailsViewModel =
        PlaceDetailsViewModel(interactor)

    @Provides
    @PlacesDetailsScope
    fun providePlacesListInteractor(repository: PlacesListRepository): PlacesListInteractor =
        PlacesListInteractor(repository)

    @Provides
    @PlacesDetailsScope
    fun providePlacesListRepository(service: PlaceService): PlacesListRepository =
        PlacesListRepository(service)
}
