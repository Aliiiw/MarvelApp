package com.example.mymarvelapp.data.network

import com.example.mymarvelapp.model.CharactersApiResponse
import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApiInterface {
    @GET("characters")
    fun getCharacters(@Query("nameStartsWith") name: String): Call<CharactersApiResponse>
}