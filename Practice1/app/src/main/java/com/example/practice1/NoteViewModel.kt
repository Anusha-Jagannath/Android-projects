package com.example.practice1

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    private val allNotes: LiveData<List<Note>>
    init {
        val dao = NoteDatabase.getDatabase(application).getNoteDao()
        val repository = NotesRepository(dao)
        allNotes = repository.allNotes
    }
}