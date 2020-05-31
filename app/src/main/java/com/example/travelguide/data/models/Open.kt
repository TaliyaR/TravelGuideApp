package com.example.travelguide.data.models


import com.google.gson.annotations.SerializedName

data class Open(
    @SerializedName("day")
    var day: Int,
    @SerializedName("time")
    var time: String
)
