package com.example.gymassistant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gymassistant.navigation.Routes
import com.example.gymassistant.ui.screens.AddExerciseScreen
import com.example.gymassistant.ui.screens.ExerciseLibraryScreen
import com.example.gymassistant.ui.screens.HomeScreen
import com.example.gymassistant.ui.screens.WorkoutHistoryScreen
import com.example.gymassistant.ui.screens.WorkoutSessionScreen
import com.example.gymassistant.ui.screens.WorkoutTemplatesScreen
import com.example.gymassistant.ui.theme.GymAssistantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            GymAssistantTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Routes.HOME,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(Routes.HOME) {
                            HomeScreen(
                                modifier = Modifier.fillMaxSize(),
                                navController = navController
                            )
                        }
                        composable(Routes.EXERCISE_LIBRARY) {
                            ExerciseLibraryScreen(
                                modifier = Modifier.fillMaxSize(),
                                navController = navController
                            )
                        }
                        composable(Routes.ADD_EXERCISE) {
                            AddExerciseScreen(
                                modifier = Modifier.fillMaxSize(),
                                navController = navController
                            )
                        }
                        composable(Routes.WORKOUT_TEMPLATES) {
                            WorkoutTemplatesScreen(
                                modifier = Modifier.fillMaxSize(),
                                navController = navController
                            )
                        }
                        composable(
                            route = Routes.WORKOUT_SESSION,
                            arguments = listOf(
                                androidx.navigation.navArgument("templateName") {
                                    type = androidx.navigation.NavType.StringType
                                }
                            )
                        ) { backStackEntry ->
                            val templateName =
                                backStackEntry.arguments?.getString("templateName") ?: "Workout"
                            WorkoutSessionScreen(
                                templateName = templateName,
                                modifier = Modifier.fillMaxSize(),
                                navController = navController
                            )
                        }
                        composable(Routes.WORKOUT_HISTORY) {
                            WorkoutHistoryScreen(
                                modifier = Modifier.fillMaxSize(),
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}