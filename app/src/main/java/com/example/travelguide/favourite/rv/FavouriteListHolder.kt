package com.example.travelguide.placesList.presentation.list.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.travelguide.BuildConfig
import com.example.travelguide.R
import com.example.travelguide.data.db.model.PlaceFromApi
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_fav.view.*


class FavouriteListHolder(
    override val containerView: View,
    private val clickLambda: (PlaceFromApi) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(place: PlaceFromApi) {
        itemView.apply {
            tv_name.text = place.name
            if (place.image != null) {
                Glide.with(this)
                    .load(getIconUrl(place.image))
                    .into(image_place)
            }
            setOnClickListener {
                clickLambda(place)
            }

        }
    }

    private fun getIconUrl(id: String?) =
        "https://maps.googleapis.com/maps/api/place/photo?maxwidth=1200&photoreference=$id&key=${BuildConfig.API_KEY}"


    companion object {

        fun create(
            parent: ViewGroup, clickLambda: (PlaceFromApi) -> Unit) =
            FavouriteListHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_fav, parent, false
                ), clickLambda
            )
    }
}
