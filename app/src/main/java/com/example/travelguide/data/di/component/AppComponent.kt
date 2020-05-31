package com.example.travelguide.data.di.component

import com.example.travelguide.app.App
import com.example.travelguide.data.di.module.AppModule
import com.example.travelguide.data.di.module.NetModule
import com.example.travelguide.data.di.module.RoomModule
import com.example.travelguide.data.di.module.ServiceModule
import com.example.travelguide.placesList.di.component.PlacesComponent
import com.example.travelguide.profile.myPlace.di.component.MyPlacesComponent
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetModule::class, ServiceModule::class, RoomModule::class])
interface AppComponent {

    fun plusPlacesComponent(): PlacesComponent.Builder

    fun plusMyPlacesComponent(): MyPlacesComponent.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }

}
