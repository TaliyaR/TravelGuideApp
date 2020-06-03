package com.example.travelguide.ui.placesList.presentation.list

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
import com.example.travelguide.app.di.Injector
import com.example.travelguide.data.ViewModelFactory
import com.example.travelguide.data.models.Result
import com.example.travelguide.ui.placesList.presentation.list.rv.NearbyPlacesListAdapter
import com.example.travelguide.utils.LocationUtils
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class ListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    var viewModel: PlacesListViewModel? = null

    private var adapter: NearbyPlacesListAdapter? = null

    private var location: String = "55.8075331,49.1783362"

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Injector.plusPlacesListComponent().inject(this)
        initViewModel()
        initLocation()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        initProgress()
    }

    private fun initLocation(): String {
        var location: String = "55.8075331,49.1783362"
        context?.let { LocationUtils.getInstance(it) }
        LocationUtils.getLocation().observe(this, Observer { loc ->
            location = "${loc.latitude},${loc.longitude}"
        })
        return location
    }

    private fun initObservers() =
        viewModel?.getPlaces(initLocation(), "2000")?.observe(this, Observer {
            when {
                it.results != null -> {
                    initRecycler(it.results.subList(1, it.results.size - 1))
                }
                else -> {
                    Snackbar.make(container, "We have problem!", Snackbar.LENGTH_SHORT)
                }
            }
        })

    private fun initProgress() = viewModel?.inProgress?.observe(this, Observer {
            progress_bar.visibility = it
        }
    )

    private fun initRecycler(list: List<Result>) {
        adapter = NearbyPlacesListAdapter(list) { Result ->
            navigateToFragment(Result.placeId)
        }
        rv_places.adapter = adapter
    }

    private fun navigateToFragment(id: String) {
        val navController = findNavController()
        val bundle = Bundle()
        bundle.putString("placeId", id)
        navController.navigate(R.id.action_listFragment_to_placeDetailsFragment, bundle)
    }

    private fun initViewModel() {
        this.viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(PlacesListViewModel::class.java)
    }

    override fun onDestroy() {
        Injector.clearPlacesListComponent()
        super.onDestroy()
    }
}
