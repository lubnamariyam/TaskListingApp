package com.lubnamariyam.tasklistingapp.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lubnamariyam.tasklistingapp.ui.view.TaskEditScreen
import com.lubnamariyam.tasklistingapp.ui.view.TaskListScreen


@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "task_screen") {
        composable("task_screen") {
            TaskListScreen(navController)
        }
        composable("task_edit_screen") {
            TaskEditScreen(navController)
        }


    }
}