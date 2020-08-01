package com.example.testapp.presentation.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.webkit.MimeTypeMap
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.example.testapp.R
import java.io.File

object ViewUtil {

    fun getProgressDrawable(context: Context): CircularProgressDrawable {
        return CircularProgressDrawable(context).apply {
            strokeWidth = 10f
            centerRadius = 50f
            start()
        }
    }

    fun ImageView.loadImage(
        uri: String?,
        progressDrawable: CircularProgressDrawable,
        imageReadyCallback: (Drawable) -> Unit
    ) {
        val options = RequestOptions()
            .placeholder(progressDrawable)
            .error(R.mipmap.ic_launcher)

        Glide.with(this.context)
            .setDefaultRequestOptions(options)
            .load(uri)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .centerCrop()
            .listener(setupRequestListener(imageReadyCallback))
            .into(this)
    }

    private fun setupRequestListener(imageReadyCallback: (Drawable) -> Unit) =
        object : RequestListener<Drawable> {
            override fun onLoadFailed(
                p0: GlideException?,
                p1: Any?,
                p2: Target<Drawable>?,
                p3: Boolean
            ): Boolean {
                return false
            }

            override fun onResourceReady(
                image: Drawable?,
                p1: Any?,
                p2: Target<Drawable>?,
                p3: DataSource?,
                p4: Boolean
            ): Boolean {
                image?.let { imageReadyCallback(it) }
                return false
            }
        }

    fun getCachedImageFile(
        context: Context,
        imageUrl: String,
        fileReadyCallback: (File, String) -> Unit
    ) {
        Glide.with(context)
            .downloadOnly()
            .apply(RequestOptions().onlyRetrieveFromCache(true))
            .load(imageUrl)
            .listener(getCachedImageFileCallback(fileReadyCallback, imageUrl))
            .submit()
    }

    private fun getCachedImageFileCallback(
        fileReadyCallback: (File, String) -> Unit,
        imageUrl: String
    ) =
        object : RequestListener<File> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<File>?,
                isFirstResource: Boolean
            ): Boolean {
                return false
            }

            override fun onResourceReady(
                resource: File?,
                model: Any?,
                target: Target<File>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                resource?.let {
                    fileReadyCallback.invoke(
                        it,
                        MimeTypeMap.getFileExtensionFromUrl(imageUrl)
                    )
                }
                return false
            }
        }


    inline var View.isVisible: Boolean
        get() = visibility == View.VISIBLE
        set(value) {
            visibility = if (value) View.VISIBLE else View.GONE
        }
}