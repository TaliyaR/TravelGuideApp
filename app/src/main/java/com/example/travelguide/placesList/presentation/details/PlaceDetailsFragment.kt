package com.example.travelguide.placesList.presentation.details

import android.content.Context
import android.os.Build.ID
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.example.travelguide.R
import com.example.travelguide.data.di.Injector
import com.example.travelguide.data.models.PlaceById
import com.example.travelguide.data.models.ResultById
import com.example.travelguide.placesList.presentation.list.PlacesListViewModel
import com.example.travelguide.presentation.ViewModelFactory
import com.example.travelguide.utils.loadPicture
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_place_details.*
import kotlinx.android.synthetic.main.item_place.view.*
import javax.inject.Inject


class PlaceDetailsFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    var placeDetailsViewModel: PlaceDetailsViewModel? = null

    private var id: String? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val bundle = this.arguments
        id = bundle?.getString("placeId")
        Injector.plusPlaceDetailsComponent().inject(this)
        initViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_place_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }

    private fun initObservers()  =
        placeDetailsViewModel?.getPlaceById(id)?.observe(this, Observer {
            when {
                it.result != null -> {
                    initViews(it.result)
                }
                else -> {
                    Snackbar.make(container, "Problem!", Snackbar.LENGTH_SHORT)
                }
            }
        })

    private fun initViewModel() {
        this.placeDetailsViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(PlaceDetailsViewModel::class.java)
    }

    override fun onDestroy() {
        Injector.clearPlaceDetailsComponent()
        super.onDestroy()
    }

    private fun initViews(result: ResultById){
        loadPicture(image_place, result.photos[0].photoReference, result.photos[0].height.toString())
        tv_name.text = result.name
        rating_bar.setRating(result.rating.toFloat())
        tv_rating.text = result.rating.toString()

    }

    companion object {
        private const val ID = "arg_id"

        fun newInstance(id: String) = PlaceDetailsFragment()

    }
}
