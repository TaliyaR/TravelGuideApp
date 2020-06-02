package com.example.travelguide.ui.favourite.di.component

import com.example.travelguide.ui.favourite.FavouriteFragment
import com.example.travelguide.ui.favourite.di.module.FavouriteListModule
import com.example.travelguide.ui.favourite.di.module.FavouriteViewModelModule
import com.example.travelguide.ui.favourite.di.scope.FavouriteListScope
import dagger.Subcomponent

@FavouriteListScope
@Subcomponent(modules = [FavouriteListModule::class, FavouriteViewModelModule::class])
interface FavouriteListComponent {
    fun inject(facouriteFragment: FavouriteFragment)

    @Subcomponent.Builder
    interface Builder {

        fun provideFavouriteListModule(favouriteModule: FavouriteListModule): Builder

        fun build(): FavouriteListComponent
    }
}
