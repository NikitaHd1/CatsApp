package com.example.testapp.di.components

import com.example.testapp.Application
import com.example.testapp.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivitiesModule::class,
        ApplicationModule::class,
        FragmentsModule::class,
        InteractorsModule::class,
        ApiModule::class,
        RepositoryModule::class,
        MappersModule::class
    ]
)
interface AppComponent : AndroidInjector<Application> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}