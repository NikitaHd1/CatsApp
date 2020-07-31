package com.example.testapp.di.modules

import com.example.testapp.domain.Interactors
import com.example.testapp.domain.interactors.GetCatsInteractorImpl
import dagger.Binds
import dagger.Module

@Module
interface InteractorsModule {

    @Binds
    fun getCatsInteractor(interactor: GetCatsInteractorImpl): Interactors.GetCatsInteractor
}