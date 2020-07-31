package com.example.testapp.domain.base

import androidx.annotation.WorkerThread

interface BaseMapper<in RemoteModel, PresentationModel> {

    @WorkerThread
    fun map(item: RemoteModel): PresentationModel

    @WorkerThread
    fun map(items: List<RemoteModel>): List<PresentationModel>
}