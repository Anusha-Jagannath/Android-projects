package com.example.practice2.repository

import androidx.lifecycle.LiveData
import com.example.practice2.dao.NoteDao
import com.example.practice2.model.Note

class NoteRepository(private val noteDao: NoteDao) {
    val allNotes: LiveData<List<Note>> = noteDao.getAllNotes()
    suspend fun insert(note: Note) {
        noteDao.insert(note)
    }
    suspend fun delete(note: Note) {
        noteDao.delete(note)
    }

}