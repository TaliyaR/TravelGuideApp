package com.example.travelguide.data.db.domain

import com.example.travelguide.data.db.model.PlaceFromApi
import com.example.travelguide.data.db.repository.PlaceApiDbRepository
import io.reactivex.Completable
import io.reactivex.Single

class PlaceApiDbInteractorImpl constructor(private val repository: PlaceApiDbRepository) :
    PlaceApiDbInteractor {

    override fun insert(placeFromApi: PlaceFromApi): Completable = repository.insert(placeFromApi)

    override fun delete(placeFromApi: PlaceFromApi): Completable = repository.delete(placeFromApi)

    override fun deleteById(id: String): Completable = repository.deleteById(id)

    override fun getAll(): Single<List<PlaceFromApi>> = repository.getAll()
}
