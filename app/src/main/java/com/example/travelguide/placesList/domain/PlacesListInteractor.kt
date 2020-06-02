package com.example.travelguide.placesList.domain

import com.example.travelguide.data.models.PlaceById
import com.example.travelguide.data.models.Places
import com.example.travelguide.placesList.data.PlacesListRepository
import io.reactivex.Single

class PlacesListInteractor constructor(
    private val placesListRepository: PlacesListRepository
) {
    fun getNearbySearch(location: String, radius: String): Single<Places> =
        placesListRepository.getNearbySearch(location, radius)

    fun getPlaceById(id: String?): Single<PlaceById> =
        placesListRepository.getPlaceById(id)
}
