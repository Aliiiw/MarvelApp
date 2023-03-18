package com.example.mymarvelapp.data

sealed class Screen(val route: String) {

    object Library : Screen("library")

    object Collection : Screen("collection")

    object CharacterDetail : Screen("character/{characterId}") {

        fun createRoute(characterId: Int?) = "character/$characterId"
    }
}
