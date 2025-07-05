package com.jasper.composenoteapp.domain

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jasper.composenoteapp.data.Note

@Database(entities = [Note::class], exportSchema = false, version = 2)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

}