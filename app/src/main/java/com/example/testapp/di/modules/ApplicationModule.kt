package com.example.testapp.di.modules

import android.content.Context
import com.example.testapp.Application
import com.example.testapp.di.qualifiers.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @Singleton
    @ApplicationContext
    fun provideApplicationContext(application: Application): Context =
        application.applicationContext
}