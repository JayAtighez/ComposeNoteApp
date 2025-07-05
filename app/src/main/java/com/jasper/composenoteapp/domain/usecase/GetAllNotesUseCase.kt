package com.jasper.composenoteapp.domain.usecase

import com.jasper.composenoteapp.data.Note
import com.jasper.composenoteapp.domain.NoteDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllNotesUseCase @Inject constructor(private val noteDao: NoteDao) {

    operator fun invoke() : Flow<List<Note>> {
        return noteDao.getAllNotes()
    }
}