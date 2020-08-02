package com.example.testapp.data.repository

import com.example.testapp.data.room.FavoriteCats
import com.example.testapp.data.models.CatsPaginationRequest
import com.example.testapp.domain.models.CatModel
import io.reactivex.Completable
import io.reactivex.Single

interface CatsRepository {

    fun getCats(params: CatsPaginationRequest): Single<List<CatModel>>

    fun deleteFavoriteCat(id: String): Completable

    fun saveFavoriteCat(favoriteCats: FavoriteCats): Completable

    fun getAllFavoriteCats(): Single<List<CatModel>>
}