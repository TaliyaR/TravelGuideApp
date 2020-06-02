package com.example.travelguide.favourite

import android.view.View
import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.travelguide.data.db.domain.PlaceApiDbInteractor
import com.example.travelguide.data.db.model.PlaceFromApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class FavouriteViewModel constructor(
    private val placeApiDbInteractor: PlaceApiDbInteractor
): ViewModel() {

    private val disposable = CompositeDisposable()

    private lateinit var places: MutableLiveData<List<PlaceFromApi>>
    val inProgress = MutableLiveData<Int>()

    @MainThread
    fun getPlaces(): LiveData<List<PlaceFromApi>> {
        places = MutableLiveData()
        inProgress.value = View.VISIBLE
        disposable.add(
            placeApiDbInteractor.getAll()
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
