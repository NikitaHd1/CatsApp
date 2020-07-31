package com.example.testapp.presentation.base

import androidx.annotation.StringRes

interface IBaseView {

    fun showError(@StringRes messageId: Int)
}