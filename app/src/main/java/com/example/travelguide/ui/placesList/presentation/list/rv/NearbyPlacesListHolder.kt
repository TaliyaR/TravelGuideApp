package com.example.travelguide.ui.placesList.presentation.list.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.travelguide.BuildConfig
import com.example.travelguide.R
import com.example.travelguide.data.models.Result
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_place.view.*

class NearbyPlacesListHolder(
    override val containerView: View,
    private val clickLambda: (Result) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    private var openning = "Открыто"

    fun bind(place: Result) {
        itemView.apply {
            tv_name.text = place.name
            tv_rating.text = place.rating.toString()
            if (place.openingHours != null) {
                if (place.openingHours.openNow == false) {
                    openning = "Закрыто"
                    itemView.tv_opening.setTextColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.red
                        )
                    )
                }
            }
            tv_opening.text = openning
            rating_bar.setRating(place.rating.toFloat())
            if (place.photos != null) {
                Glide.with(this)
                    .load(getIconUrl(place.photos[0].photoReference))
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
            parent: ViewGroup,
            clickLambda: (Result) -> Unit
        ) = NearbyPlacesListHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_place, parent, false
                ), clickLambda
            )
    }
}
