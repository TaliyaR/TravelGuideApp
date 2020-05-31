package com.example.travelguide.data.db.domain

import com.example.travelguide.data.db.model.Place
import io.reactivex.Completable
import io.reactivex.Single

interface PlaceDbInteractor {

    fun insert(place: Place): Completable

    fun delete(place: Place): Completable

    fun update(place: Place): Completable

    fun getById(id: Int?): Single<Place>

    fun getAll(): Single<List<Place>>
}
