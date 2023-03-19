package com.example.mymarvelapp.utils

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AttributionText(text: String) {
    Text(text = text, modifier = Modifier.padding(start = 8.dp, top = 4.dp), fontSize = 12.sp)
}
