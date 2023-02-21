package com.example.jetbizcard_course

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CreateInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Wahid R.",
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primaryVariant
        )
        Text(
            text = "Android Developer",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.subtitle1
        )
        Text(
            text = "@beining&bogen.no",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.subtitle2
        )
    }
}