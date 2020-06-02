package com.example.travelguide.data.db.repository

import com.example.travelguide.data.db.dao.PlaceFromApiDAO
import com.example.travelguide.data.db.model.PlaceFromApi
import io.reactivex.Completable
import io.reactivex.Single

class PlaceApiDbRepositoryImpl constructor(private val placeFromApiDAO: PlaceFromApiDAO): PlaceApiDbRepository{

    override fun insert(placeFromApi: PlaceFromApi): Completable  = placeFromApiDAO.insert(placeFromApi)

    override fun delete(placeFromApi: PlaceFromApi): Completable = placeFromApiDAO.delete(placeFromApi)

    override fun deleteById(id: String): Completable = placeFromApiDAO.deleteById(id)

    override fun getAll(): Single<List<PlaceFromApi>> = placeFromApiDAO.getAll()
}
