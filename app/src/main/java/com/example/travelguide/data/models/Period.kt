package com.example.travelguide.data.models


import com.google.gson.annotations.SerializedName

data class Period(
    @SerializedName("close")
    var close: Close,
    @SerializedName("open")
    var `open`: Open
)
