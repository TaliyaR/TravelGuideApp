package com.example.travelguide.app.di

import com.example.travelguide.app.App
import com.example.travelguide.app.di.component.AppComponent
import com.example.travelguide.app.di.component.DaggerAppComponent
import com.example.travelguide.ui.favourite.di.component.FavouriteComponent
import com.example.travelguide.ui.favourite.di.component.FavouriteListComponent
import com.example.travelguide.ui.placesList.di.component.PlaceDetailsComponent
import com.example.travelguide.ui.placesList.di.component.PlacesComponent
import com.example.travelguide.ui.placesList.di.component.PlacesListComponent
import com.example.travelguide.ui.profile.add.di.component.AddMyPlaceComponent
import com.example.travelguide.ui.profile.details.di.component.MyPlaceDetailsComponent
import com.example.travelguide.ui.profile.myPlace.di.component.MyPlacesComponent
import com.example.travelguide.ui.profile.myPlace.di.component.MyPlacesListComponent

object Injector {
    lateinit var appComponent: AppComponent
    private var placesComponent: PlacesComponent? = null
    private var placesListComponent: PlacesListComponent? = null
    private var placeDetailsComponent: PlaceDetailsComponent? = null
    private var myPlaceComponent: MyPlacesComponent? = null
    private var myPlacesListComponent: MyPlacesListComponent? = null
    private var addMyPlaceComponent: AddMyPlaceComponent? = null
    private var myPlaceDetailsComponent: MyPlaceDetailsComponent? = null
    private var favouriteComponent: FavouriteComponent? = null
    private var favouriteListComponent: FavouriteListComponent? = null

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

    fun plusFavouriteComponent(): FavouriteComponent = favouriteComponent ?: appComponent
        .plusFavouriteComponent()
        .build().also {
            favouriteComponent = null
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

    fun plusMyPlaceDetailsComponent(): MyPlaceDetailsComponent =
        myPlaceDetailsComponent ?: plusMyPlacesComponent()
            .plusMyPlaceDetailsComponentBuilder()
            .build().also {
                myPlaceDetailsComponent = it
            }

    fun clearMyPlaceDetailsComponent(){
        myPlaceDetailsComponent = null
    }

    fun plusFavouriteListComponent(): FavouriteListComponent =
        favouriteListComponent ?: plusFavouriteComponent()
            .plusFavouriteListComponentBuilder()
            .build().also {
                favouriteListComponent = it
            }

    fun clearFavouriteListComponent(){
        favouriteListComponent = null
    }

}
