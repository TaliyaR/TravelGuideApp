package com.example.travelguide.data.db.dao

import androidx.room.*
import com.example.travelguide.data.db.model.Place
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface PlaceDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(place: Place): Completable

    @Query("SELECT * FROM place")
    fun getAll(): Single<List<Place>>

    @Query("SELECT * FROM place WHERE id=:id")
    fun getById(id: Int?): Single<Place>

    @Update
    fun update(place: Place): Completable

    @Delete
    fun delete(place: Place): Completable
}
