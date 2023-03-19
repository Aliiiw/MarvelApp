package com.example.mymarvelapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymarvelapp.viewmodel.repository.MarvelApiRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LibraryApiViewModel @Inject constructor(private val repo: MarvelApiRepo) : ViewModel() {
    val result = repo.characters
    val queryText = MutableStateFlow("")
    private val queryInput = Channel<String>(Channel.CONFLATED)

    init {
        retrieveCharacters()
    }

    @OptIn(FlowPreview::class)
    private fun retrieveCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            queryInput.receiveAsFlow()
                .filter { validateQuery(it) }
                .debounce(1000)
                .collect {
                    repo.query(it)
                }
        }
    }

    private fun validateQuery(query: String): Boolean = query.length >= 2

    fun onQueryUpdate(input: String) {
        queryText.value = input
        queryInput.trySend(input)
    }
}