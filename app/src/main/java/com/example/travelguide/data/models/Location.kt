package com.example.travelguide.data.models


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("lat")
    var lat: Double,
    @SerializedName("lng")
    var lng: Double
)
