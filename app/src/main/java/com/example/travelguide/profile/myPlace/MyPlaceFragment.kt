package com.example.travelguide.profile.myPlace

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.travelguide.R
import com.example.travelguide.data.db.model.Place
import com.example.travelguide.data.di.Injector
import com.example.travelguide.placesList.presentation.list.rv.PlacesListAdapter
import com.example.travelguide.presentation.ViewModelFactory
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_my_place.*
import javax.inject.Inject

class MyPlaceFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    var viewModel: MyPlaceViewModel? = null


    private var adapter: PlacesListAdapter? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Injector.plusMyPlaceListComponent().inject(this)
        initViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_place, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        clickListener()
    }

    private fun initObservers() {
        viewModel?.getPlaces()?.observe(this, Observer {
            when {
                it != null -> {
                    initRecycler(it)
                }
                else -> {
                    Snackbar.make(container, "We have problem!", Snackbar.LENGTH_SHORT)
                }
            }
        })
    }

    fun clickListener() {
        fab.setOnClickListener {
            val navController = findNavController()
            navController.navigate(R.id.action_myPlaceFragment_to_addPlaceFragment)
        }
    }

    private fun initRecycler(list: List<Place>) {
        adapter = PlacesListAdapter(list) { Place ->
            navigateToFragment(Place)
        }
        rv_favourite_places.adapter = adapter
        if (list.isEmpty()) {
            image_for_null.visibility = View.VISIBLE
            tv_head.visibility = View.VISIBLE
            tv_head2.visibility = View.VISIBLE
        }
    }

    private fun navigateToFragment(place: Place) {
        val navController = findNavController()
        val bundle = Bundle()
        place.id?.let { bundle.putInt("placeId", it) }
        navController.navigate(R.id.action_myPlaceFragment_to_myPlaceDetailsFragment, bundle)
    }

    private fun initViewModel() {
        this.viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(MyPlaceViewModel::class.java)
    }

    override fun onDestroy() {
        Injector.clearMyPlaceListComponent()
        super.onDestroy()
    }
}
