package com.example.travelguide.placesList.presentation.list.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.travelguide.R
import com.example.travelguide.data.db.model.Place
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_favourite_place.view.*

class PlacesListHolder(
    override val containerView: View,
    private val clickLambda: (Place) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(place: Place) {
        itemView.apply {
            tv_name.text = place.name
            tv_address.text = place.address
            if (place.image != null) {
                Glide.with(this)
//                Picasso.with(context)
                    .load(context.assets.open("photo.jpeg"))
//                    .load(Uri.parse(place.image))
                    .into(image_place)
            }
            setOnClickListener {
                clickLambda(place)
            }
        }
    }

    companion object {

        fun create(parent: ViewGroup, clickLambda: (Place) -> Unit) =
            PlacesListHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_favourite_place, parent, false
                ),
                clickLambda
            )
    }
}
