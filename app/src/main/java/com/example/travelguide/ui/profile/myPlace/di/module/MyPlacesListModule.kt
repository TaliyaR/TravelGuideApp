package com.example.travelguide.ui.profile.myPlace.di.module

import com.example.travelguide.data.db.dao.PlaceDAO
import com.example.travelguide.data.db.domain.PlaceDbInteractor
import com.example.travelguide.data.db.domain.PlaceDbInteractorImpl
import com.example.travelguide.data.db.repository.PlaceDbRepository
import com.example.travelguide.data.db.repository.PlaceDbRepositoryImpl
import com.example.travelguide.ui.profile.myPlace.MyPlaceViewModel
import com.example.travelguide.ui.profile.myPlace.di.scope.MyPlacesListScope
import dagger.Module
import dagger.Provides

@Module
class MyPlacesListModule {

    @Provides
    @MyPlacesListScope
    fun provideMyPlaceViewModel(interactor: PlaceDbInteractor): MyPlaceViewModel =
        MyPlaceViewModel(interactor)

    @Provides
    @MyPlacesListScope
    fun provideMyPlacesInteractor(repository: PlaceDbRepository): PlaceDbInteractor =
        PlaceDbInteractorImpl(repository)

    @Provides
    @MyPlacesListScope
    fun provideMyPlacesRepository(dao: PlaceDAO): PlaceDbRepository =
        PlaceDbRepositoryImpl(dao)
}
