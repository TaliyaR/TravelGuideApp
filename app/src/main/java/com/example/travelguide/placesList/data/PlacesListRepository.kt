package com.example.travelguide.placesList.data

import com.example.travelguide.data.PlaceService
import com.example.travelguide.data.models.PlaceById
import com.example.travelguide.data.models.Places
import io.reactivex.Single

class PlacesListRepository constructor(
    private var placeService: PlaceService
) {

    fun getNearbySearch(
        location: String, radius: String
    ): Single<Places> = placeService.getNearbySearch(location, radius)

    fun getPlaceById(id: String?): Single<PlaceById> = placeService.getPlaceById(id)
}
