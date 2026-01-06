package com.example.gymassistant.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun WorkoutHistoryScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    // Placeholder in‑memory history
    val history = remember {
        mutableStateListOf(
            "2024‑01‑01: Push Day",
            "2024‑01‑03: Pull Day"
        )
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Workout History")
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(history) { entry ->
                Text(text = entry)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

