package com.example.testapp.presentation.base

interface IBasePresenter<in V : IBaseView> {

    fun attachView(view: V)

    fun detachView()
}