package com.example.gymassistant.ui.states

data class MuscleNodeModel (
    val value: Enum<*>,
    val subgroups: List<MuscleNodeModel> = emptyList()
)