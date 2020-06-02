package com.example.travelguide.ui.placesList.presentation.list.rv

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.travelguide.data.db.model.PlaceFromApi

class FavouriteListAdapter(
    private var list: List<PlaceFromApi>,
    private val clickLambda: (PlaceFromApi) -> Unit
) : RecyclerView.Adapter<FavouriteListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteListHolder =
        FavouriteListHolder.create(parent, clickLambda)

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: FavouriteListHolder, position: Int) {
        holder.bind(list[position])
    }
}
