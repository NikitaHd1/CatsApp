package com.example.testapp.di.modules

import com.example.testapp.domain.Mappers
import com.example.testapp.domain.mappers.CatModelMapperImpl
import com.example.testapp.domain.mappers.CatsRequestMapperImpl
import com.example.testapp.domain.mappers.CatsResponseMapperImpl
import com.example.testapp.domain.mappers.FavoriteCatsMapperImpl
import dagger.Binds
import dagger.Module

@Module
interface MappersModule {

    @Binds
    fun bindImageResponseMapper(mapper: CatsResponseMapperImpl): Mappers.CatsResponseMapper

    @Binds
    fun bindImageQueryMapper(mapper: CatsRequestMapperImpl): Mappers.CatsRequestMapper

    @Binds
    fun bindFavoriteCatsMapper(mapper: FavoriteCatsMapperImpl): Mappers.FavoriteCatsMapper

    @Binds
    fun bindCatModelMapper(mapper: CatModelMapperImpl): Mappers.CatModelMapper
}