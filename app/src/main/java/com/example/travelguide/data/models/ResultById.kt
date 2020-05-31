package com.example.travelguide.data.models

import com.google.gson.annotations.SerializedName

data class ResultById(
    @SerializedName("address_components")
    var addressComponents: List<AddressComponent>,
    @SerializedName("adr_address")
    var adrAddress: String,
    @SerializedName("business_status")
    var businessStatus: String,
    @SerializedName("formatted_address")
    var formattedAddress: String,
    @SerializedName("formatted_phone_number")
    var formattedPhoneNumber: String,
    @SerializedName("geometry")
    var geometry: Geometry,
    @SerializedName("icon")
    var icon: String,
    @SerializedName("id")
    var id: String,
    @SerializedName("international_phone_number")
    var internationalPhoneNumber: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("opening_hours")
    var openingHours: OpeningHours,
    @SerializedName("photos")
    var photos: List<Photo>,
    @SerializedName("place_id")
    var placeId: String,
    @SerializedName("plus_code")
    var plusCode: PlusCode,
    @SerializedName("rating")
    var rating: Double,
    @SerializedName("reference")
    var reference: String,
    @SerializedName("reviews")
    var reviews: List<Review>,
    @SerializedName("scope")
    var scope: String,
    @SerializedName("types")
    var types: List<String>,
    @SerializedName("url")
    var url: String,
    @SerializedName("utc_offset")
    var utcOffset: Int,
    @SerializedName("vicinity")
    var vicinity: String,
    @SerializedName("website")
    var website: String
)
