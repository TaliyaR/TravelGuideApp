package com.example.travelguide.ui.favourite.di.component

import com.example.travelguide.ui.favourite.di.module.FavouriteModule
import com.example.travelguide.ui.favourite.di.scope.FavouriteScope
import dagger.Subcomponent

@FavouriteScope
@Subcomponent(modules = [FavouriteModule::class])
interface FavouriteComponent {

    fun plusFavouriteListComponentBuilder(): FavouriteListComponent.Builder

    @Subcomponent.Builder
    interface Builder {

        fun provideFavouriteModule(favouriteModule: FavouriteModule): Builder

        fun build(): FavouriteComponent
    }
}
