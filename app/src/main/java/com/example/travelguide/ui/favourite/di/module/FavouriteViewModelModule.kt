package com.example.travelguide.ui.favourite.di.module

import androidx.lifecycle.ViewModel
import com.example.travelguide.app.di.module.ViewModelModule
import com.example.travelguide.app.di.scope.ViewModelKey
import com.example.travelguide.ui.favourite.FavouriteViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelModule::class])
abstract class FavouriteViewModelModule {

    @IntoMap
    @Binds
    @ViewModelKey(FavouriteViewModel::class)
    abstract fun bindFavouriteViewModel(
        favouriteViewModel: FavouriteViewModel
    ): ViewModel
}
