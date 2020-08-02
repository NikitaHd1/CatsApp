package com.example.testapp.presentation.dialogs

import androidx.annotation.LayoutRes
import com.example.testapp.presentation.base.BaseDialogFragment

abstract class FullscreenDialogFragment(@LayoutRes val dialogLayoutRes: Int) :
    BaseDialogFragment(dialogLayoutRes) {

    override val isFullscreen: Boolean
        get() = true
}