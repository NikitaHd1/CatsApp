package com.example.testapp.di.modules

import android.content.Context
import androidx.room.Room
import com.example.testapp.data.room.AppDatabase
import com.example.testapp.di.qualifiers.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "DemoDb"
    ).build()

    @Provides
    fun provideCatDao(addDatabase: AppDatabase) = addDatabase.catDao()
}