package com.jasper.composenoteapp.domain.usecase

import com.jasper.composenoteapp.data.Note
import com.jasper.composenoteapp.domain.NoteDao
import javax.inject.Inject

class InsertNoteUseCase @Inject constructor(private val noteDao: NoteDao) {

    suspend operator fun invoke(note: Note) {
        noteDao.insertNote(note = note)
    }

}