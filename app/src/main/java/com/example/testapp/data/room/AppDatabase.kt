package com.example.testapp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FavoriteCats::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun catDao(): CatDao
}