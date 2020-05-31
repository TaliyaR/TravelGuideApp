package com.example.travelguide.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.travelguide.data.db.dao.PlaceDAO
import com.example.travelguide.data.db.model.Place

@Database(entities = [Place::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun placeDAO(): PlaceDAO

    companion object{
        const val DATABASE_NAME = "task.db"
    }

}
