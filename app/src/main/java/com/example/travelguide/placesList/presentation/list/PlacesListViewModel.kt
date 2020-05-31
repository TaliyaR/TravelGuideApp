package com.example.travelguide.placesList.presentation.list

import android.view.View
import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.travelguide.data.models.Places
import com.example.travelguide.placesList.domain.PlacesListInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PlacesListViewModel constructor(
    private val placesListInteractor: PlacesListInteractor
) : ViewModel() {

    private val disposable = CompositeDisposable()

    private lateinit var places: MutableLiveData<Places>
    val inProgress = MutableLiveData<Int>()

    @MainThread
    fun getPlaces(location: String, radius: String): LiveData<Places> {
        places = MutableLiveData()
        inProgress.value = View.VISIBLE
        disposable.add(
            placesListInteractor.getNearbySearch(location, radius)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    inProgress.value = View.GONE
                    places.value = result
                },
                    { error ->
                        inProgress.value = View.GONE
                    })
        )
        return places
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}
