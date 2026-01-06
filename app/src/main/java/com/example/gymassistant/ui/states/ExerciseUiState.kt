package com.example.gymassistant.ui.states

import com.example.gymassistant.ui.models.MuscleWorked

data class ExerciseUiState (
    val name: String = "",
    val groupsWorked: List<MuscleWorked> = emptyList()
)