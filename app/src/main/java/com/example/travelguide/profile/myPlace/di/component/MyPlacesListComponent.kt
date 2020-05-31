package com.example.travelguide.profile.myPlace.di.component

import com.example.travelguide.profile.myPlace.MyPlaceFragment
import com.example.travelguide.profile.myPlace.di.module.MyPlaceViewModelModule
import com.example.travelguide.profile.myPlace.di.module.MyPlacesListModule
import com.example.travelguide.profile.myPlace.di.scope.MyPlacesListScope
import dagger.Subcomponent

@MyPlacesListScope
@Subcomponent(modules = [MyPlacesListModule::class, MyPlaceViewModelModule::class])
interface MyPlacesListComponent {

    fun inject(myPlaceFragment: MyPlaceFragment)

    @Subcomponent.Builder
    interface Builder {

        fun provideMyPlaceModule(myPlacesModule: MyPlacesListModule): Builder

        fun build(): MyPlacesListComponent

    }
}
