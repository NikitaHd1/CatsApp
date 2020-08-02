package com.example.testapp.data.lacal

import com.example.testapp.data.room.FavoriteCats
import io.reactivex.Completable
import io.reactivex.Single

interface LocalStore {

    fun deleteFavoriteCat(id: String): Completable

    fun saveFavoriteCat(favoriteCats: FavoriteCats): Completable

    fun getAllFavoriteCats(): Single<List<FavoriteCats>>
}