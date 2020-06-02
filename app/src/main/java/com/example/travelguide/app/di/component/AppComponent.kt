package com.example.travelguide.app.di.component

import com.example.travelguide.app.App
import com.example.travelguide.app.di.module.AppModule
import com.example.travelguide.app.di.module.NetModule
import com.example.travelguide.app.di.module.RoomModule
import com.example.travelguide.app.di.module.ServiceModule
import com.example.travelguide.ui.favourite.di.component.FavouriteComponent
import com.example.travelguide.ui.placesList.di.component.PlacesComponent
import com.example.travelguide.ui.profile.myPlace.di.component.MyPlacesComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetModule::class, ServiceModule::class, RoomModule::class])
interface AppComponent {

    fun plusPlacesComponent(): PlacesComponent.Builder

    fun plusMyPlacesComponent(): MyPlacesComponent.Builder

    fun plusFavouriteComponent(): FavouriteComponent.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }

}
