package com.example.testapp.di.modules

import com.example.testapp.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivitiesModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity
}