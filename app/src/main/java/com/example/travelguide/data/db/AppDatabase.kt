package com.example.travelguide.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.travelguide.data.db.dao.PlaceDAO
import com.example.travelguide.data.db.dao.PlaceFromApiDAO
import com.example.travelguide.data.db.model.Place
import com.example.travelguide.data.db.model.PlaceFromApi

@Database(entities = [Place::class, PlaceFromApi::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun placeDAO(): PlaceDAO

    abstract fun placeFromApiDao(): PlaceFromApiDAO

    companion object{
        const val DATABASE_NAME = "task.db"
    }

}
