package com.example.testapp.di.modules

import com.example.testapp.presentation.catslist.CatsListFragment
import com.example.testapp.presentation.catslist.CatsListModule
import com.example.testapp.presentation.favorites.FavoriteListFragment
import com.example.testapp.presentation.favorites.FavoriteListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentsModule {

    @ContributesAndroidInjector(modules = [CatsListModule::class])
    fun bindCatListFragment(): CatsListFragment

    @ContributesAndroidInjector(modules = [FavoriteListModule::class])
    fun bindFavoriteListFragment(): FavoriteListFragment
}