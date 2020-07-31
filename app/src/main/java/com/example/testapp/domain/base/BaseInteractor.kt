package com.example.testapp.domain.base

import androidx.annotation.WorkerThread

interface BaseInteractor<in InputModel, out OutputModel> {

    @WorkerThread
    fun execute(parameters: InputModel): OutputModel
}