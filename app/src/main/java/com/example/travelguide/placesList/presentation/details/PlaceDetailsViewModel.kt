package com.example.travelguide.placesList.presentation.details

import android.view.View
import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.travelguide.data.models.PlaceById
import com.example.travelguide.data.models.ResultById
import com.example.travelguide.placesList.domain.PlacesListInteractor
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PlaceDetailsViewModel constructor(
    private val placesListInteractor: PlacesListInteractor
): ViewModel() {

    private val disposable = CompositeDisposable()
    private lateinit var place: MutableLiveData<PlaceById>
    val inProgress = MutableLiveData<Int>()

    @MainThread
    fun getPlaceById(id: String?): LiveData<PlaceById>{
        place = MutableLiveData()
        inProgress.value = View.VISIBLE
        disposable.add(
            placesListInteractor.getPlaceById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    inProgress.value = View.GONE
                    place.value = result
                },
                    {
                        error ->
                        inProgress.value = View.GONE

                })
        )
        return place
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}
