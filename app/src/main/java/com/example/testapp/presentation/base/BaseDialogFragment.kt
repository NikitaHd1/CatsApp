package com.example.testapp.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment
import com.example.testapp.R
import dagger.android.support.DaggerDialogFragment

abstract class BaseDialogFragment(@LayoutRes val layoutRes: Int = 0) : DaggerDialogFragment(),
    IBaseView {

    abstract val isFullscreen: Boolean

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isFullscreen) {
            setStyle(DialogFragment.STYLE_NORMAL, R.style.Widget_AppCompat_Toolbar)
        }
    }

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

    override fun showSuccessMessage(messageId: Int) {
        (requireActivity() as? BaseActivity)?.showSuccessMessage(messageId)
    }
}