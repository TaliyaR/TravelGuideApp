package com.example.travelguide.placesList.di.module

import com.example.travelguide.data.PlaceService
import com.example.travelguide.data.db.dao.PlaceFromApiDAO
import com.example.travelguide.data.db.domain.PlaceApiDbInteractor
import com.example.travelguide.data.db.domain.PlaceApiDbInteractorImpl
import com.example.travelguide.data.db.repository.PlaceApiDbRepository
import com.example.travelguide.data.db.repository.PlaceApiDbRepositoryImpl
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
    fun providePlaceDetailsViewModel(interactor: PlacesListInteractor, apiInteractor: PlaceApiDbInteractor): PlaceDetailsViewModel =
        PlaceDetailsViewModel(interactor, apiInteractor)

    @Provides
    @PlacesDetailsScope
    fun providePlacesListInteractor(repository: PlacesListRepository): PlacesListInteractor =
        PlacesListInteractor(repository)

    @Provides
    @PlacesDetailsScope
    fun providePlacesListRepository(service: PlaceService): PlacesListRepository =
        PlacesListRepository(service)

    @Provides
    @PlacesDetailsScope
    fun provideApiInteractor(apiRepository: PlaceApiDbRepository): PlaceApiDbInteractor =
        PlaceApiDbInteractorImpl(apiRepository)

    @Provides
    @PlacesDetailsScope
    fun provideApiRepository(dao: PlaceFromApiDAO): PlaceApiDbRepository =
        PlaceApiDbRepositoryImpl(dao)
}
