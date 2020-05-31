package com.example.travelguide.data.db.domain

import androidx.lifecycle.LiveData
import com.example.travelguide.data.db.model.Place
import com.example.travelguide.data.db.repository.PlaceDbRepository
import io.reactivex.Single

class PlaceDbInteractorImpl constructor(
    private val repository: PlaceDbRepository
) : PlaceDbInteractor {
    override fun insert(place: Place) =
        repository.insert(place)

    override fun getById(id: Int?): Single<Place> = repository.getById(id)

    override fun delete(place: Place) = repository.delete(place)

    override fun update(place: Place) = repository.update(place)

    override fun getAll(): Single<List<Place>> = repository.getAll()
}
