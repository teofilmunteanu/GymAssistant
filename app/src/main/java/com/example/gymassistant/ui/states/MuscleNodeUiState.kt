package com.example.gymassistant.ui.states

data class MuscleNodeUiState (
    val value: Enum<*>,
    val subgroups: List<MuscleNodeUiState> = emptyList()
)