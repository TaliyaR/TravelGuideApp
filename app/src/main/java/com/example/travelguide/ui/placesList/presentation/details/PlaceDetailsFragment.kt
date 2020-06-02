package com.example.travelguide.ui.placesList.presentation.details

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.travelguide.R
import com.example.travelguide.data.db.model.PlaceFromApi
import com.example.travelguide.app.di.Injector
import com.example.travelguide.data.models.ResultById
import com.example.travelguide.data.ViewModelFactory
import com.example.travelguide.utils.loadPicture
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_place_details.*
import javax.inject.Inject


class PlaceDetailsFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    var placeDetailsViewModel: PlaceDetailsViewModel? = null

    private var id: String? = null

    private lateinit var sharedPreferences: SharedPreferences

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

    private fun initButton(place: ResultById) {
        btn_favourite.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                placeDetailsViewModel?.saveIdToDB(
                    PlaceFromApi(
                        place.placeId, place.name, place.photos[0].photoReference
                    ))

            } else {
                placeDetailsViewModel?.deleteFromDb(place.placeId)
            }
        }
    }

    private fun initObservers() =
        placeDetailsViewModel?.getPlaceById(id)?.observe(this, Observer {
            when {
                it.result != null -> {
                    initViews(it.result)
                    initButton(it.result)
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

    private fun initViews(result: ResultById) {
        loadPicture(
            image_place,
            result.photos[0].photoReference,
            result.photos[0].height.toString()
        )
        tv_name.text = result.name
        rating_bar.rating = result.rating.toFloat()
        if (!result.permanentlyClosed) {
            tv_opening.text = "Closed"
            tv_opening.setTextColor(resources.getColor(R.color.red))
        } else {
            tv_opening.text = "Open"
        }
        tv_rating.text = result.rating.toString()
        tv_address.text = result.formattedAddress
        tv_phone.text = result.formattedPhoneNumber
    }
}
