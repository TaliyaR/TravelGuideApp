package com.example.travelguide.placesList.presentation.details

import android.content.SharedPreferences
import android.view.View
import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.travelguide.data.db.domain.PlaceApiDbInteractor
import com.example.travelguide.data.db.model.PlaceFromApi
import com.example.travelguide.data.models.PlaceById
import com.example.travelguide.placesList.domain.PlacesListInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PlaceDetailsViewModel constructor(
    private val placesListInteractor: PlacesListInteractor,
    private val placeApiDbInteractor: PlaceApiDbInteractor
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

    fun saveIdToDB(placeFromApi: PlaceFromApi){
        disposable.add(
            placeApiDbInteractor.insert(placeFromApi)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
        )
    }

    fun deleteFromDb(id: String){
        disposable.add(
            placeApiDbInteractor.deleteById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}
