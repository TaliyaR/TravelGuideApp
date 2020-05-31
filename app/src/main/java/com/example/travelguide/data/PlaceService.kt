package com.example.travelguide.data

import com.example.travelguide.data.models.PlaceById
import com.example.travelguide.data.models.Places
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {

    @GET("/maps/api/place/nearbysearch/json")
    fun getNearbySearch(
        @Query("location") location: String,
        @Query("radius") radius: String
    ): Single<Places>

    @GET("details/json")
    fun getPlaceById(
        @Query("placeid") placeId: String?
    ): Single<PlaceById>
}
