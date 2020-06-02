package com.example.travelguide.favourite.di.component

import com.example.travelguide.favourite.FavouriteFragment
import com.example.travelguide.favourite.di.module.FavouriteListModule
import com.example.travelguide.favourite.di.module.FavouriteViewModelModule
import com.example.travelguide.favourite.di.scope.FavouriteListScope
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
