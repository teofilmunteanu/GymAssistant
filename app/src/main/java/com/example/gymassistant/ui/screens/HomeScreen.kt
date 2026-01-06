package com.example.gymassistant.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gymassistant.navigation.Routes

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController
    ) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Gym Assistant")

        Button(onClick = { navController.navigate(Routes.EXERCISE_LIBRARY) }) {
            Text("Exercise Library")
        }

        Button(onClick = { navController.navigate(Routes.WORKOUT_TEMPLATES) }) {
            Text("Workout Templates")
        }

        Button(onClick = { navController.navigate(Routes.WORKOUT_HISTORY) }) {
            Text("Workout History")
        }
    }
}

