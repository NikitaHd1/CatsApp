package com.example.testapp.presentation.base

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import dagger.android.support.DaggerFragment

abstract class BaseFragment(@LayoutRes val layoutRes: Int = 0) : DaggerFragment(), IBaseView {

    companion object {
        private const val WRITE_REQUEST_CODE = 163
    }

    private var onWritePermissionGrantedListener: (() -> Unit)? = null

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

    fun checkWritePermission(onWritePermissionGrantedListener: () -> Unit) {
        val permissions = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        val hasPermission = ContextCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        if (hasPermission == PackageManager.PERMISSION_GRANTED) {
            this.onWritePermissionGrantedListener = null
            onWritePermissionGrantedListener.invoke()
        } else {
            this.onWritePermissionGrantedListener = onWritePermissionGrantedListener
            requestPermissions(permissions, WRITE_REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == WRITE_REQUEST_CODE && permissions.contains(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                onWritePermissionGrantedListener?.invoke()
            }
            onWritePermissionGrantedListener = null
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}