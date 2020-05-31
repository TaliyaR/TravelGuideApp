package com.example.travelguide.data.models


import com.google.gson.annotations.SerializedName

data class PlaceById(
    @SerializedName("html_attributions")
    var htmlAttributions: List<Any>,
    @SerializedName("result")
    var result: ResultById,
    @SerializedName("status")
    var status: String
)
