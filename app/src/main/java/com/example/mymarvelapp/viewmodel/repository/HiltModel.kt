package com.example.mymarvelapp.viewmodel.repository

import com.example.mymarvelapp.data.network.MarvelApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class HiltModel {
    @Provides
    fun provideApiRepo() = MarvelApiRepo(MarvelApiService.api)
}