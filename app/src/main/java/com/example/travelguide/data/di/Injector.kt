package com.example.travelguide.data.di

import com.example.travelguide.app.App
import com.example.travelguide.data.di.component.AppComponent
import com.example.travelguide.data.di.component.DaggerAppComponent
import com.example.travelguide.placesList.di.component.PlaceDetailsComponent
import com.example.travelguide.placesList.di.component.PlacesComponent
import com.example.travelguide.placesList.di.component.PlacesListComponent
import com.example.travelguide.profile.add.di.component.AddMyPlaceComponent
import com.example.travelguide.profile.myPlace.di.component.MyPlacesComponent
import com.example.travelguide.profile.myPlace.di.component.MyPlacesListComponent

object Injector {
    lateinit var appComponent: AppComponent
    private var placesComponent: PlacesComponent? = null
    private var placesListComponent: PlacesListComponent? = null
    private var placeDetailsComponent: PlaceDetailsComponent? = null
    private var myPlaceComponent: MyPlacesComponent? = null
    private var myPlacesListComponent: MyPlacesListComponent? = null
    private var addMyPlaceComponent: AddMyPlaceComponent? = null

    fun init(app: App) {
        appComponent = DaggerAppComponent.builder()
            .application(app)
            .build()
    }

    fun plusMyPlacesComponent(): MyPlacesComponent = myPlaceComponent ?: appComponent
        .plusMyPlacesComponent()
        .build().also {
            myPlaceComponent = it
        }
    fun clearMyPlacesComponent(){
        myPlaceComponent = null
    }

    fun plusPlacesComponent(): PlacesComponent = placesComponent ?: appComponent
        .plusPlacesComponent()
        .build().also {
            placesComponent = it
        }

    fun clearPlacesComponent() {
        placesComponent = null
    }

    fun plusPlacesListComponent(): PlacesListComponent =
        placesListComponent ?: plusPlacesComponent()
            .plusPlacesListComponentBuilder()
            .build().also {
                placesListComponent = it
            }

    fun clearPlacesListComponent() {
        placesListComponent = null
    }

    fun plusPlaceDetailsComponent(): PlaceDetailsComponent =
        placeDetailsComponent ?: plusPlacesComponent()
            .plusPlaceDetailsComponentBuilder()
            .build().also {
                placeDetailsComponent = it
            }

    fun clearPlaceDetailsComponent() {
        placeDetailsComponent = null
    }

    fun plusMyPlaceListComponent(): MyPlacesListComponent =
        myPlacesListComponent ?: plusMyPlacesComponent()
            .plusMyPlaceComponentBuilder()
            .build().also {
                myPlacesListComponent = it
            }

    fun clearMyPlaceListComponent(){
        myPlaceComponent = null
    }

    fun plusAddMyPlaceComponent(): AddMyPlaceComponent =
        addMyPlaceComponent ?: plusMyPlacesComponent()
            .plusAddMyPlaceComponentBuilder()
            .build().also {
                addMyPlaceComponent = it
            }

    fun clearAddMyPlaceComponent(){
        addMyPlaceComponent = null
    }

}
