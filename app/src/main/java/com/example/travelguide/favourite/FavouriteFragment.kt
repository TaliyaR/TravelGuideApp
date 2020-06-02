package com.example.travelguide.favourite

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
import com.example.travelguide.data.db.model.PlaceFromApi
import com.example.travelguide.data.di.Injector
import com.example.travelguide.placesList.presentation.list.rv.FavouriteListAdapter
import com.example.travelguide.presentation.ViewModelFactory
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_favourite.*
import javax.inject.Inject

class FavouriteFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    var viewModel: FavouriteViewModel? = null

    private var adapter: FavouriteListAdapter? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Injector.plusFavouriteListComponent().inject(this)
        initViewModel()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favourite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initObservers()
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

    private fun initRecycler(list: List<PlaceFromApi>) {
        adapter = FavouriteListAdapter(list) { PlaceFromApi ->
            navigateToFragment(PlaceFromApi)
        }
        rv_fav.adapter = adapter
        if (list.isEmpty()) {
            image_for_null.visibility = View.VISIBLE
            tv_head.visibility = View.VISIBLE
        }
    }

    private fun navigateToFragment(place: PlaceFromApi) {
        val navController = findNavController()
        val bundle = Bundle()
        place.googleId?.let { bundle.putString("placeId", it) }
        navController.navigate(R.id.action_favouriteFragment_to_placeDetailsFragment, bundle)
    }

    private fun initViewModel() {
        this.viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(FavouriteViewModel::class.java)
    }

    override fun onDestroy() {
        Injector.clearFavouriteListComponent()
        super.onDestroy()
    }

}
