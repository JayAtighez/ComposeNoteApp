package com.jasper.composenoteapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jasper.composenoteapp.screens.AddNoteScreen
import com.jasper.composenoteapp.screens.NotesListScreen
import com.jasper.composenoteapp.viewmodel.NoteViewModel

@Composable
fun NoteAppNavigation(navController: NavHostController) {

    val noteViewModel = hiltViewModel<NoteViewModel>()

    NavHost(navController, startDestination = "NotesListScreen") {
        composable(route = "NotesListScreen") {
            NotesListScreen(
                noteViewModel,
                navigateToNoteInputScreen = {
                    navController.navigate("AddNoteScreen")
                }
            )
        }
        composable(route = "AddNoteScreen") {
            AddNoteScreen(
                noteViewModel,
                navigateBackToNotesScreen = {
                    navController.navigateUp()
                },
                onNavigateBack = {
                    navController.navigateUp()
                }
            )
        }
    }
}