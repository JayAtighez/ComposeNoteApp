package com.jasper.composenoteapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jasper.composenoteapp.screens.AddNoteScreen
import com.jasper.composenoteapp.screens.NotesListScreen

@Composable
fun NoteAppNavigation(navController: NavHostController) {

    NavHost(navController, startDestination = "NotesListScreen") {
        composable(route = "NotesListScreen") {
            NotesListScreen()
        }
        composable(route = "NotesListScreen") {
            AddNoteScreen(
                navigateBackToNotesScreen = {
                    navController.navigateUp()
                }
            )
        }
    }
}