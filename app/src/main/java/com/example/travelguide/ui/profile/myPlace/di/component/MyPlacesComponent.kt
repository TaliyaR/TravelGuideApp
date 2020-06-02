package com.example.travelguide.ui.profile.myPlace.di.component

import com.example.travelguide.ui.profile.add.di.component.AddMyPlaceComponent
import com.example.travelguide.ui.profile.details.di.component.MyPlaceDetailsComponent
import com.example.travelguide.ui.profile.myPlace.di.module.MyPlacesModule
import com.example.travelguide.ui.profile.myPlace.di.scope.MyPlaceScope
import dagger.Subcomponent

@Subcomponent(modules = [MyPlacesModule::class])
@MyPlaceScope
interface MyPlacesComponent {

    fun plusMyPlaceComponentBuilder(): MyPlacesListComponent.Builder

    fun plusAddMyPlaceComponentBuilder(): AddMyPlaceComponent.Builder

    fun plusMyPlaceDetailsComponentBuilder(): MyPlaceDetailsComponent.Builder

    @Subcomponent.Builder
    interface Builder {

        fun provideMyPlacesModule(myPlacesModule: MyPlacesModule): Builder

        fun build(): MyPlacesComponent
    }
}
