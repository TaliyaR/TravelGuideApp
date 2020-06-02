package com.example.travelguide.ui.placesList.di.component

import com.example.travelguide.ui.placesList.di.module.PlacesListModule
import com.example.travelguide.ui.placesList.di.module.PlacesListViewModelModule
import com.example.travelguide.ui.placesList.di.scope.PlacesListScope
import com.example.travelguide.ui.placesList.presentation.list.ListFragment
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
