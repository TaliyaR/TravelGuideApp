package com.example.travelguide.data.db.dao

import androidx.room.*
import com.example.travelguide.data.db.model.PlaceFromApi
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface PlaceFromApiDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(placeFromApi: PlaceFromApi): Completable

    @Delete
    fun delete(placeFromApi: PlaceFromApi): Completable

    @Query("DELETE FROM place_api WHERE googleId=:id")
    fun deleteById(id: String): Completable

    @Query("SELECT * FROM place_api")
    fun getAll(): Single<List<PlaceFromApi>>
}
