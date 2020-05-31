package com.example.travelguide.data.models


import com.google.gson.annotations.SerializedName

data class Review(
    @SerializedName("author_name")
    var authorName: String,
    @SerializedName("author_url")
    var authorUrl: String,
    @SerializedName("language")
    var language: String,
    @SerializedName("profile_photo_url")
    var profilePhotoUrl: String,
    @SerializedName("rating")
    var rating: Int,
    @SerializedName("relative_time_description")
    var relativeTimeDescription: String,
    @SerializedName("text")
    var text: String,
    @SerializedName("time")
    var time: Int
)
