package com.example.travelguide.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Place (
    @PrimaryKey(autoGenerate = true)
    var id: Int?,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "address")
    var address: String,
    @ColumnInfo(name = "description")
    var description: String,
    @ColumnInfo(name = "image")
    var image: String?
)


