package com.example.mymarvelapp.viewmodel.repository

import android.content.Context
import androidx.room.Room
import com.example.mymarvelapp.data.network.MarvelApiService
import com.example.mymarvelapp.model.connectivity.ConnectivityMonitor
import com.example.mymarvelapp.model.db.*
import com.example.mymarvelapp.model.db.Constants.DB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
class HiltModel {
    @Provides
    fun provideApiRepo() = MarvelApiRepo(MarvelApiService.api)

    @Provides
    fun provideCollectionDb(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, CollectionDb::class.java, DB).build()

    @Provides
    fun provideCharacterDao(collectionDb: CollectionDb) = collectionDb.characterDao()

    @Provides
    fun provideNoteDao(collectionDb: CollectionDb) = collectionDb.noteDao()

    @Provides
    fun provideDbRepoImpl(characterDao: CharacterDao, noteDao: NoteDao): CollectionDbRepo =
        CollectionDbRepoImplementation(characterDao = characterDao, noteDao = noteDao)

    @Provides
    fun provideConnectivityManager(@ApplicationContext context: Context) =
        ConnectivityMonitor.getInstance(context)

}