package com.example.notesapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    val allNotes: LiveData<List<Note>>

    init {
        val database = NoteDatabase.getDatabase(application).noteDao()
        val repository = NoteRepository(database)
        allNotes = repository.allNotes
    }
}