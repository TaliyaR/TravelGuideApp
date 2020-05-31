package com.example.travelguide.data.models


import com.google.gson.annotations.SerializedName

data class Viewport(
    @SerializedName("northeast")
    var northeast: Northeast,
    @SerializedName("southwest")
    var southwest: Southwest
)
