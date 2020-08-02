package com.example.testapp.data.repository

import com.example.testapp.data.lacal.LocalStore
import com.example.testapp.data.room.FavoriteCats
import com.example.testapp.data.models.CatsPaginationRequest
import com.example.testapp.data.network.ApiService
import com.example.testapp.domain.Mappers
import javax.inject.Inject

class CatsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val localStore: LocalStore,
    private val catsResponseMapper: Mappers.CatsResponseMapper,
    private val favoriteCatsMapper: Mappers.FavoriteCatsMapper
) : CatsRepository {

    override fun getCats(params: CatsPaginationRequest) =
        apiService.getCats(params.limit, params.page, params.order).map(catsResponseMapper::map)

    override fun deleteFavoriteCat(id: String) = localStore.deleteFavoriteCat(id)

    override fun saveFavoriteCat(favoriteCats: FavoriteCats) =
        localStore.saveFavoriteCat(favoriteCats)

    override fun getAllFavoriteCats() = localStore.getAllFavoriteCats().map(favoriteCatsMapper::map)
}