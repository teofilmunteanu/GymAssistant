package com.example.gymassistant.navigation

object Routes {
    const val HOME = "home"
    const val EXERCISE_LIBRARY = "exerciseLibrary"
    const val ADD_EXERCISE = "addExercise"
    const val WORKOUT_TEMPLATES = "workoutTemplates"
    const val WORKOUT_SESSION = "workoutSession/{templateName}"
    const val WORKOUT_HISTORY = "workoutHistory"

    fun workoutSession(templateName: String): String =
        "workoutSession/$templateName"
}

