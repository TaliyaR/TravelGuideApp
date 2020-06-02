package com.example.travelguide.profile.details.di.model

import com.example.travelguide.data.db.dao.PlaceDAO
import com.example.travelguide.data.db.domain.PlaceDbInteractor
import com.example.travelguide.data.db.domain.PlaceDbInteractorImpl
import com.example.travelguide.data.db.repository.PlaceDbRepository
import com.example.travelguide.data.db.repository.PlaceDbRepositoryImpl
import com.example.travelguide.profile.details.MyPlaceDetailsViewModel
import com.example.travelguide.profile.details.di.scope.MyDetailsScope
import dagger.Module
import dagger.Provides

@Module
class MyPlaceDetailsModule {

    @Provides
    @MyDetailsScope
    fun provideMyDetailsPlaceViewModel(interactor: PlaceDbInteractor): MyPlaceDetailsViewModel =
        MyPlaceDetailsViewModel(interactor)

    @Provides
    @MyDetailsScope
    fun provideMyDetailsPlacesInteractor(repository: PlaceDbRepository): PlaceDbInteractor =
        PlaceDbInteractorImpl(repository)

    @Provides
    @MyDetailsScope
    fun provideMyDetailsPlacesRepository(dao: PlaceDAO): PlaceDbRepository =
        PlaceDbRepositoryImpl(dao)
}
