package com.example.testapp.di.modules

import com.example.testapp.data.lacal.LocalStore
import com.example.testapp.data.lacal.LocalStoreImpl
import dagger.Binds
import dagger.Module

@Module
interface LocalStoreModule {

    @Binds
    fun bindLocalStore(localStoreImpl: LocalStoreImpl): LocalStore
}