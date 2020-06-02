package com.example.travelguide.ui.placesList.presentation.list.rv

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.travelguide.data.db.model.Place

class PlacesListAdapter(
    private var list: List<Place>,
    private val clickLambda: (Place) -> Unit
) : RecyclerView.Adapter<PlacesListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlacesListHolder =
        PlacesListHolder.create(parent, clickLambda)

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PlacesListHolder, position: Int) {
        holder.bind(list[position])
    }
}
