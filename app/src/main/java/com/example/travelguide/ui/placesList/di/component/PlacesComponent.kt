package com.example.travelguide.ui.placesList.di.component

import com.example.travelguide.ui.placesList.di.module.PlacesModule
import com.example.travelguide.ui.placesList.di.scope.PlacesScope
import dagger.Subcomponent

@Subcomponent(modules = [PlacesModule::class])
@PlacesScope
interface PlacesComponent {

    fun plusPlacesListComponentBuilder(): PlacesListComponent.Builder

    fun plusPlaceDetailsComponentBuilder(): PlaceDetailsComponent.Builder

    @Subcomponent.Builder
    interface Builder {

        fun providePlacesModule(placesModule: PlacesModule): Builder

        fun build(): PlacesComponent
    }

}
