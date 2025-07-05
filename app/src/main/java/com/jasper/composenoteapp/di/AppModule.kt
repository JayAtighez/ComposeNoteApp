package com.jasper.composenoteapp.di

import android.content.Context
import androidx.room.Room
import com.jasper.composenoteapp.domain.NoteDao
import com.jasper.composenoteapp.domain.NoteDatabase
import com.jasper.composenoteapp.domain.usecase.GetAllNotesUseCase
import com.jasper.composenoteapp.domain.usecase.InsertNoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNotesDatabase(@ApplicationContext context: Context): NoteDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            klass = NoteDatabase::class.java,
            name = "notes_db"
        )
            .fallbackToDestructiveMigration(false)
            .build()
    }

    @Provides
    @Singleton
    fun provideNoteDao(database: NoteDatabase): NoteDao {
        return database.noteDao()
    }

    @Provides
    @Singleton
    fun provideInsertNoteUseCase(noteDao: NoteDao) = InsertNoteUseCase(noteDao)

    @Provides
    @Singleton
    fun provideGetAllNotesUseCase(noteDao: NoteDao) = GetAllNotesUseCase(noteDao)
}