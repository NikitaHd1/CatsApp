package com.example.testapp.di.modules

import com.example.testapp.domain.Interactors
import com.example.testapp.domain.interactors.SaveToFavoriteCatsInteractorImpl
import com.example.testapp.domain.interactors.DeleteFavoriteCatInteractorImpl
import com.example.testapp.domain.interactors.GetCatsInteractorImpl
import com.example.testapp.domain.interactors.GetFavoriteCatsInteractorImpl
import dagger.Binds
import dagger.Module

@Module
interface InteractorsModule {

    @Binds
    fun bindCatsInteractor(interactor: GetCatsInteractorImpl): Interactors.GetCatsInteractor

    @Binds
    fun bindFavoriteCatsInteractor(interactor: GetFavoriteCatsInteractorImpl): Interactors.GetFavoriteCatsInteractor

    @Binds
    fun bindAddCatsInteractor(interactor: SaveToFavoriteCatsInteractorImpl): Interactors.SaveToFavoriteCatsInteractor

    @Binds
    fun bindsDeleteInteractor(interactor: DeleteFavoriteCatInteractorImpl): Interactors.DeleteFavoriteCatInteractor
}