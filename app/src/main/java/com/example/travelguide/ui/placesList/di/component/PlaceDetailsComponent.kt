package com.example.travelguide.ui.placesList.di.component

import com.example.travelguide.ui.placesList.di.module.PlaceDetailsModule
import com.example.travelguide.ui.placesList.di.module.PlacesDetailsViewModelModule
import com.example.travelguide.ui.placesList.di.scope.PlacesDetailsScope
import com.example.travelguide.ui.placesList.presentation.details.PlaceDetailsFragment
import dagger.Subcomponent

@PlacesDetailsScope
@Subcomponent(modules = [PlaceDetailsModule::class, PlacesDetailsViewModelModule::class])
interface PlaceDetailsComponent {

    fun inject(placeDetailsFragment: PlaceDetailsFragment)

    @Subcomponent.Builder
    interface Builder {

        fun providePlaceDetailsModule(placeDetailsModule: PlaceDetailsModule): Builder

        fun build(): PlaceDetailsComponent
    }
}
