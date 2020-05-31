package com.example.travelguide.data.models


import com.google.gson.annotations.SerializedName

data class AddressComponent(
    @SerializedName("long_name")
    var longName: String,
    @SerializedName("short_name")
    var shortName: String,
    @SerializedName("types")
    var types: List<String>
)
