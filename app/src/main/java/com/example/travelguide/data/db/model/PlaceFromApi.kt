package com.example.travelguide.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "place_api")
data class PlaceFromApi(
    @PrimaryKey
    var googleId: String,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "image")
    var image: String?
)
