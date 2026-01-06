package com.example.gymassistant.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gymassistant.navigation.Routes

@Composable
fun ExerciseLibraryScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Exercise Library")
        Spacer(modifier = Modifier.height(16.dp))

        // TODO: show exercises grouped by muscle group

        Button(onClick = { navController.navigate(Routes.ADD_EXERCISE) }) {
            Text(text = "Add Exercise")
        }
    }
}