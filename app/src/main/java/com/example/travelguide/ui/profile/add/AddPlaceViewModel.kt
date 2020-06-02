package com.example.travelguide.ui.profile.add

import android.util.Log
import androidx.annotation.MainThread
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.travelguide.data.db.domain.PlaceDbInteractor
import com.example.travelguide.data.db.model.Place
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AddPlaceViewModel constructor(
    private val placeDbInteractor: PlaceDbInteractor
): ViewModel() {

    private val disposable = CompositeDisposable()

    private lateinit var place: MutableLiveData<Place>
    val inProgress = MutableLiveData<Int>()

    @MainThread
    fun savePlace(place: Place){
        disposable.add(
            placeDbInteractor.insert(place)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
        )
        Log.i("db", place.image)
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}
