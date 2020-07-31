package com.example.testapp.di.modules

import com.example.testapp.data.repository.CatsRepository
import com.example.testapp.data.repository.CatsRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun bindRepository(repository: CatsRepositoryImpl): CatsRepository
}