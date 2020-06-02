package com.example.travelguide.profile.myPlace

import android.view.View
import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.travelguide.data.db.domain.PlaceDbInteractor
import com.example.travelguide.data.db.model.Place
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MyPlaceViewModel constructor(
    private val placeDbInteractor: PlaceDbInteractor
): ViewModel() {

    private val disposable = CompositeDisposable()

    private lateinit var places: MutableLiveData<List<Place>>
    val inProgress = MutableLiveData<Int>()

    @MainThread
    fun getPlaces(): LiveData<List<Place>> {
        places = MutableLiveData()
        inProgress.value = View.VISIBLE
        disposable.add(
            placeDbInteractor.getAll()
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
