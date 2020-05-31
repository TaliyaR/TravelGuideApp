package com.example.travelguide.data.db.repository

import com.example.travelguide.data.db.dao.PlaceDAO
import com.example.travelguide.data.db.model.Place
import io.reactivex.Single

class PlaceDbRepositoryImpl constructor (
    private val placeDAO: PlaceDAO): PlaceDbRepository {
    override fun insert(place: Place) = placeDAO.insert(place)

    override fun delete(place: Place) = placeDAO.delete(place)

    override fun update(place: Place) = placeDAO.update(place)

    override fun getById(id: Int?): Single<Place>  = placeDAO.getById(id)

    override fun getAll(): Single<List<Place>> = placeDAO.getAll()
}
