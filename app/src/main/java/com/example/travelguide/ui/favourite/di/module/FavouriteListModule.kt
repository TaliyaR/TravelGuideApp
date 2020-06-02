package com.example.travelguide.ui.favourite.di.module

import com.example.travelguide.data.db.dao.PlaceFromApiDAO
import com.example.travelguide.data.db.domain.PlaceApiDbInteractor
import com.example.travelguide.data.db.domain.PlaceApiDbInteractorImpl
import com.example.travelguide.data.db.repository.PlaceApiDbRepository
import com.example.travelguide.data.db.repository.PlaceApiDbRepositoryImpl
import com.example.travelguide.ui.favourite.FavouriteViewModel
import com.example.travelguide.ui.favourite.di.scope.FavouriteListScope
import dagger.Module
import dagger.Provides

@Module
class FavouriteListModule {

    @Provides
    @FavouriteListScope
    fun provideFavouriteViewModel(interactor: PlaceApiDbInteractor): FavouriteViewModel =
        FavouriteViewModel(interactor)

    @Provides
    @FavouriteListScope
    fun provideApiDbInteractor(repository: PlaceApiDbRepository): PlaceApiDbInteractor =
        PlaceApiDbInteractorImpl(repository)

    @Provides
    @FavouriteListScope
    fun provideApiDbRepository(dao: PlaceFromApiDAO): PlaceApiDbRepository =
        PlaceApiDbRepositoryImpl(dao)
}
