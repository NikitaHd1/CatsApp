package com.example.testapp.data.repository

import com.example.testapp.data.models.CatItemResponse
import com.example.testapp.data.room.FavoriteCats
import com.example.testapp.data.models.CatsPaginationRequest
import io.reactivex.Completable
import io.reactivex.Single

interface CatsRepository {

    fun getCats(params: CatsPaginationRequest): Single<List<CatItemResponse>>

    fun deleteFavoriteCat(id: String): Completable

    fun saveFavoriteCat(favoriteCats: FavoriteCats): Completable

    fun getAllFavoriteCats(): Single<List<FavoriteCats>>
}