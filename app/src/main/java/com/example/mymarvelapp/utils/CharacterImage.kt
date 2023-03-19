package com.example.mymarvelapp.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

@Composable
fun CharacterImage(
    url: String,
    modifier: Modifier,
    contentScale: ContentScale = ContentScale.FillWidth
) {
    AsyncImage(
        model = url,
        contentDescription = "",
        modifier = modifier,
        contentScale = contentScale
    )
}


fun List<String>.comicsToString() = this.joinToString(separator = ", ")