package com.example.mymarvelapp.model.connectivity

import kotlinx.coroutines.flow.Flow

interface ConnectivityObservable {
    fun observe(): Flow<Status>

    enum class Status {
        AVAILABLE, UNAVAILABLE
    }
}