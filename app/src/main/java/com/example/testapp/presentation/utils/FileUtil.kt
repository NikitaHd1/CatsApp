package com.example.testapp.presentation.utils

import android.os.Environment
import java.io.File

object FileUtil {

    fun saveImage(
        imageFile: File,
        imageName: String,
        fileExtension: String,
        onSuccessListener: () -> Unit,
        onFailureListener: (String?) -> Unit
    ) {
        try {
            val downloadFolderPath =
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)?.absolutePath
            val newFile = File("$downloadFolderPath/$imageName.$fileExtension")
            imageFile.copyTo(newFile)
            onSuccessListener()
        } catch (e: Exception) {
            onFailureListener(e.message)
            e.printStackTrace()
        }
    }
}