package com.example.travelguide.ui.placesList.presentation.list.rv

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.travelguide.data.models.Result

class NearbyPlacesListAdapter(
    private var list: List<Result>,
    private val clickLambda: (Result) -> Unit
) : RecyclerView.Adapter<NearbyPlacesListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NearbyPlacesListHolder =
        NearbyPlacesListHolder.create(parent, clickLambda)

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: NearbyPlacesListHolder, position: Int) {
        holder.bind(list[position])
    }
}
