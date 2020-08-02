package com.example.testapp.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoriteCats(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "url") val imageUrl: String
)