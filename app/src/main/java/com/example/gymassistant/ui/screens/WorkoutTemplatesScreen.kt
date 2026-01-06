package com.example.gymassistant.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gymassistant.navigation.Routes

@Composable
fun WorkoutTemplatesScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val templates = remember { mutableStateListOf("Push Day", "Pull Day", "Leg Day") }
    val (newTemplateName, setNewTemplateName) = remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Workout Templates")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = newTemplateName,
            onValueChange = setNewTemplateName,
            label = { Text("New template name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                if (newTemplateName.isNotBlank()) {
                    templates += newTemplateName.trim()
                    setNewTemplateName("")
                }
            }
        ) {
            Text("Add template")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(templates) { template ->
                Text(
                    text = template,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(Routes.workoutSession(template))
                        }
                        .padding(vertical = 8.dp)
                )
            }
        }
    }
}

