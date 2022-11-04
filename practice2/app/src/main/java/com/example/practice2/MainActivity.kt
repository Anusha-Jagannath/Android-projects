package com.example.practice2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practice2.model.Note
import com.example.practice2.viewmodel.NoteViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), INotesRVAdapter {
    private lateinit var viewModel: NoteViewModel
    private lateinit var adapter: NotesRVAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(NoteViewModel::class.java)

        viewModel.allNotes.observe(this, {
            it?.let {
                adapter.updateList(it)
            }
        })
    }

    override fun onItemClick(note: Note) {
        viewModel.deleteNote(note)
        Toast.makeText(this,"note deleted",Toast.LENGTH_SHORT).show()
    }

    private fun init() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = NotesRVAdapter(this, this)
        recyclerView.adapter = adapter
    }

    fun submit(view: View) {
        val text = inputNote.text.toString()
        if (text.isNotEmpty()) {
            viewModel.insertNote(Note(text))
            Toast.makeText(this,"note inserted",Toast.LENGTH_SHORT).show()
            inputNote.text.clear()
        }
        else { Toast.makeText(this,"empty not discarded",Toast.LENGTH_SHORT).show()}
    }
}