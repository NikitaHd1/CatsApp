package com.example.testapp.di.modules

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.testapp.di.qualifiers.ActivityContext
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
abstract class BaseModule<ViewImpl : View, View, PresenterImpl : Presenter, Presenter> {

    @Provides
    fun bindView(view: ViewImpl): View = view

    @Provides
    fun bindPresenter(presenter: PresenterImpl): Presenter = presenter

    @Provides
    @ActivityContext
    open fun provideActivityContext(view: ViewImpl): Context {
        return when (view) {
            is AppCompatActivity -> view
            is Fragment -> view.requireContext()
            is DialogFragment -> view.requireContext()
            else -> throw Exception("View implementation can't be casted to any view.")
        }
    }

    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()
}