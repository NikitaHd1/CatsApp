package com.example.testapp.presentation.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

abstract class BasePresenter<T : IBaseView> : IBasePresenter<T> {

    @Inject
    lateinit var compositeDisposable: CompositeDisposable

    var view: T? = null

    override fun attachView(view: T) {
        this.view = view
    }

    override fun detachView() {
        view = null
        if (compositeDisposable.isDisposed.not()) {
            compositeDisposable.clear()
        }
    }

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }
}
