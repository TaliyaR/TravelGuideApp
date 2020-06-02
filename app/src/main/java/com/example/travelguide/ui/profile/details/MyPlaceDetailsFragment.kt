package com.example.travelguide.ui.profile.details

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide

import com.example.travelguide.R
import com.example.travelguide.data.db.model.Place
import com.example.travelguide.app.di.Injector
import com.example.travelguide.data.ViewModelFactory
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_add_place.*
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
        id = bundle?.getInt("placeId")
        Injector.plusMyPlaceDetailsComponent().inject(this)
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
        Injector.clearMyPlaceDetailsComponent()
        super.onDestroy()
    }

    private fun initViews(place: Place){
        tv_name.text = place.name
        tv_address.text = place.address
        tv_about.text = place.description
        Glide.with(this)
            .load(Uri.parse(place.image))
            .into(image_place)
    }

}
