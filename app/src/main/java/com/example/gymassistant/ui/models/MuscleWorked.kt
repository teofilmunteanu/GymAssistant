package com.example.gymassistant.ui.models

import com.example.gymassistant.constants.MuscleGroup

data class MuscleWorked(
    val group: MuscleGroup,
    val subgroup: Enum<*>? = null
)
