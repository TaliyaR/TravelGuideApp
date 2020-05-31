package com.example.travelguide.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.travelguide.BuildConfig

fun loadPicture(imageView: ImageView, id: String, width: String) {
    val url = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=1200&photoreference=$id&key=${BuildConfig.API_KEY}"
    Glide.with(imageView.context)
        .load(url)
        .into(imageView)
}
