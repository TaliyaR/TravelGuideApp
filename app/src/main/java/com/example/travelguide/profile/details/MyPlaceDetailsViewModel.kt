package com.example.travelguide.profile.details

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.travelguide.data.db.domain.PlaceDbInteractor
import com.example.travelguide.data.db.model.Place
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MyPlaceDetailsViewModel constructor(
    private val placeDbInteractor: PlaceDbInteractor
): ViewModel() {

    private val disposable = CompositeDisposable()

    private lateinit var place: MutableLiveData<Place>

    @MainThread
    fun getPlaceById(id: Int?): LiveData<Place>{
        place = MutableLiveData()
        disposable.add(
            placeDbInteractor.getById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { result ->
                    place.value = result
                }
        )
        return place
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}
