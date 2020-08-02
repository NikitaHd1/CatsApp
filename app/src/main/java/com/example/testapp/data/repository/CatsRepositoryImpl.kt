package com.example.testapp.data.repository

import com.example.testapp.data.lacal.LocalStore
import com.example.testapp.data.room.FavoriteCats
import com.example.testapp.data.models.CatsPaginationRequest
import com.example.testapp.data.network.ApiService
import javax.inject.Inject

class CatsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val localStore: LocalStore
) : CatsRepository {

    override fun getCats(params: CatsPaginationRequest) =
        apiService.getCats(params.limit, params.page, params.order)

    override fun deleteFavoriteCat(id: String) = localStore.deleteFavoriteCat(id)

    override fun saveFavoriteCat(favoriteCats: FavoriteCats) =
        localStore.saveFavoriteCat(favoriteCats)

    override fun getAllFavoriteCats() = localStore.getAllFavoriteCats()
}