package com.example.testapp.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import dagger.android.support.DaggerFragment

abstract class BaseFragment(@LayoutRes val layoutRes: Int = 0) : DaggerFragment(), IBaseView {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = if (layoutRes != 0) {
        inflater.inflate(layoutRes, container, false)
    } else {
        super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun showError(messageId: Int) {
        (requireActivity() as? BaseActivity)?.showError(messageId)
    }
}