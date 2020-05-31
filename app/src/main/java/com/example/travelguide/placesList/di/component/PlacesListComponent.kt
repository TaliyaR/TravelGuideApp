package com.example.travelguide.placesList.di.component

import com.example.travelguide.placesList.di.module.PlacesListModule
import com.example.travelguide.placesList.di.module.PlacesListViewModelModule
import com.example.travelguide.placesList.di.scope.PlacesListScope
import com.example.travelguide.placesList.presentation.list.ListFragment
import dagger.Subcomponent

@Subcomponent(modules = [PlacesListModule::class, PlacesListViewModelModule::class])
@PlacesListScope
interface PlacesListComponent {

    fun inject(listFragment: ListFragment)

    @Subcomponent.Builder
    interface Builder {

        fun placesListModule(placesModule: PlacesListModule): Builder

        fun build(): PlacesListComponent
    }

}
