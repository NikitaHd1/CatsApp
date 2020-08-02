package com.example.testapp.domain.mappers

import com.example.testapp.data.room.FavoriteCats
import com.example.testapp.domain.Mappers
import com.example.testapp.domain.models.CatModel
import javax.inject.Inject

class FavoriteCatsMapperImpl @Inject constructor() : Mappers.FavoriteCatsMapper {

    override fun map(item: FavoriteCats) = CatModel(item.id, item.imageUrl)

    override fun map(items: List<FavoriteCats>): List<CatModel> = when {
        items.isEmpty() -> listOf()
        else -> items
            .asSequence()
            .map(this::map)
            .toList()
    }
}