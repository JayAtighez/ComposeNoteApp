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
            NotesListScreen(
                navigateToNoteInputScreen = {
                    navController.navigate("AddNoteScreen")
                }
            )
        }
        composable(route = "AddNoteScreen") {
            AddNoteScreen(
                navigateBackToNotesScreen = {
                    navController.navigateUp()
                }
            )
        }
    }
}