package com.example.notesapplication

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
class Note(@PrimaryKey(autoGenerate = true) val id: Int, val text: String) {



}