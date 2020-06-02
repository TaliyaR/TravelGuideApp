package com.example.travelguide.ui.profile.add.di.model

import com.example.travelguide.data.db.dao.PlaceDAO
import com.example.travelguide.data.db.domain.PlaceDbInteractor
import com.example.travelguide.data.db.domain.PlaceDbInteractorImpl
import com.example.travelguide.data.db.repository.PlaceDbRepository
import com.example.travelguide.data.db.repository.PlaceDbRepositoryImpl
import com.example.travelguide.ui.profile.add.AddPlaceViewModel
import com.example.travelguide.ui.profile.add.di.scope.AddPlaceScope
import dagger.Module
import dagger.Provides

@Module
class AddPlaceModule {

    @Provides
    @AddPlaceScope
    fun provideAddPlaceViewModel(interactor: PlaceDbInteractor): AddPlaceViewModel =
        AddPlaceViewModel(interactor)

    @Provides
    @AddPlaceScope
    fun provideMyPlacesInteractor(repository: PlaceDbRepository): PlaceDbInteractor =
        PlaceDbInteractorImpl(repository)

    @Provides
    @AddPlaceScope
    fun provideMyPlacesRepository(dao: PlaceDAO): PlaceDbRepository =
        PlaceDbRepositoryImpl(dao)
}
