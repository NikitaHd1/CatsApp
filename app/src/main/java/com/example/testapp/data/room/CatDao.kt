package com.example.testapp.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CatDao {
    @Query("SELECT * FROM favoriteCats")
    fun getAllCats(): List<FavoriteCats>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg users: FavoriteCats): List<Long>

    @Query("DELETE FROM favoriteCats WHERE id = :id")
    fun delete(id: String): Int
}