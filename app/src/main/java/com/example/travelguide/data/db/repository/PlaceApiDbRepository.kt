package com.example.travelguide.data.db.repository

import com.example.travelguide.data.db.model.PlaceFromApi
import io.reactivex.Completable
import io.reactivex.Single

interface PlaceApiDbRepository {

    fun insert(placeFromApi: PlaceFromApi): Completable

    fun delete(placeFromApi: PlaceFromApi): Completable

    fun deleteById(id: String): Completable

    fun getAll(): Single<List<PlaceFromApi>>
}
