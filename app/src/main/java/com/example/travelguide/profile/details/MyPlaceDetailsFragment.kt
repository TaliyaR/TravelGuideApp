package com.example.travelguide.profile.details

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.example.travelguide.R
import com.example.travelguide.data.db.model.Place
import com.example.travelguide.data.di.Injector
import com.example.travelguide.data.models.ResultById
import com.example.travelguide.placesList.presentation.details.PlaceDetailsViewModel
import com.example.travelguide.presentation.ViewModelFactory
import com.example.travelguide.utils.loadPicture
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_my_place_details.*
import javax.inject.Inject

class MyPlaceDetailsFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    var myPlaceDetailsViewModel: MyPlaceDetailsViewModel? = null

    private var id: Int? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val bundle = this.arguments
        id = bundle?.getString("placeId")?.toInt()
        initViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_place_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }

    private fun initObservers()  =
        myPlaceDetailsViewModel?.getPlaceById(id)?.observe(this, Observer {
            when {
                it != null ->{
                    initViews(it)
                }
                else -> {
                    Snackbar.make(container, "Problem!", Snackbar.LENGTH_SHORT)
                }
            }
        })


    private fun initViewModel() {
        this.myPlaceDetailsViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(MyPlaceDetailsViewModel::class.java)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun initViews(place: Place){
        tv_name.text = place.name
        tv_address.text = place.address
        tv_about.text = place.description
    }

}
