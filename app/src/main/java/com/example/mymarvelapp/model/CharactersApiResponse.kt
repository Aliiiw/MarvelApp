package com.example.mymarvelapp.model

data class CharactersApiResponse(
    val code: String?,
    val status: String?,
    val attributionText: String?,
    val data: CharactersData?
)
