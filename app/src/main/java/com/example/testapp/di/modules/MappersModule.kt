package com.example.testapp.di.modules

import com.example.testapp.domain.Mappers
import com.example.testapp.domain.mappers.CatsRequestMapperImpl
import com.example.testapp.domain.mappers.CatsResponseMapperImpl
import dagger.Binds
import dagger.Module

@Module
interface MappersModule {

    @Binds
    fun bindImageResponseMapper(mapper: CatsResponseMapperImpl): Mappers.CatsResponseMapper

    @Binds
    fun bindImageQueryMapper(mapper: CatsRequestMapperImpl): Mappers.CatsRequestMapper
}