package com.example.gymassistant.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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

@Composable
fun WorkoutSessionScreen(
    templateName: String,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    data class SetEntry(
        val exercise: String,
        val reps: String,
        val weight: String,
        val rest: String
    )

    val sets = remember { mutableStateListOf<SetEntry>() }
    val (exercise, setExercise) = remember { mutableStateOf("") }
    val (reps, setReps) = remember { mutableStateOf("") }
    val (weight, setWeight) = remember { mutableStateOf("") }
    val (rest, setRest) = remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Workout: $templateName")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = exercise,
            onValueChange = setExercise,
            label = { Text("Exercise") },
            modifier = Modifier.fillMaxSize()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = reps,
            onValueChange = setReps,
            label = { Text("Reps") },
            modifier = Modifier.fillMaxSize()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = weight,
            onValueChange = setWeight,
            label = { Text("Weight") },
            modifier = Modifier.fillMaxSize()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = rest,
            onValueChange = setRest,
            label = { Text("Rest (seconds)") },
            modifier = Modifier.fillMaxSize()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                if (exercise.isNotBlank()) {
                    sets += SetEntry(
                        exercise = exercise,
                        reps = reps,
                        weight = weight,
                        rest = rest
                    )
                    setExercise("")
                    setReps("")
                    setWeight("")
                    setRest("")
                }
            }
        ) {
            Text("Add set")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(sets) { set ->
                Text(text = "${set.exercise}: ${set.reps} reps @ ${set.weight}kg, rest ${set.rest}s")
                Spacer(modifier = Modifier.height(4.dp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // TODO: persist workout to history
                navController.popBackStack()
            }
        ) {
            Text("End workout")
        }
    }
}

