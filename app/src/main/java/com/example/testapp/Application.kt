package com.example.testapp

import com.example.testapp.di.components.AppComponent
import com.example.testapp.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class Application : DaggerApplication() {

    lateinit var appComponent: AppComponent
        private set

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()

        return appComponent
    }
}