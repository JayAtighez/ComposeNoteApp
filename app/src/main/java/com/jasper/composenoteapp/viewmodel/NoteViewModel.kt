package com.jasper.composenoteapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jasper.composenoteapp.data.Note
import com.jasper.composenoteapp.domain.usecase.GetAllNotesUseCase
import com.jasper.composenoteapp.domain.usecase.InsertNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val insertNoteUseCase: InsertNoteUseCase,
    getAllNotesUseCase: GetAllNotesUseCase
) : ViewModel() {

    val notesList: StateFlow<List<Note>> = getAllNotesUseCase()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun insertNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            insertNoteUseCase(note)
        }
    }

}