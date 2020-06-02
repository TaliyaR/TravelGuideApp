package com.example.travelguide.data.db.domain

import com.example.travelguide.data.db.model.PlaceFromApi
import io.reactivex.Completable
import io.reactivex.Single

interface PlaceApiDbInteractor {

    fun insert(placeFromApi: PlaceFromApi): Completable

    fun delete(placeFromApi: PlaceFromApi): Completable

    fun deleteById(id: String): Completable

    fun getAll(): Single<List<PlaceFromApi>>
}
