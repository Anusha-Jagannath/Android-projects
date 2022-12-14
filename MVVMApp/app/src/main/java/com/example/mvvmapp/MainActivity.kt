package com.example.mvvmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), INotesRVAdaptor {

    lateinit var viewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adaptor = NotesRVAdaptor(this, this)
        recyclerView.adapter = adaptor


        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(NoteViewModel::class.java)
        viewModel.allNotes.observe(this, Observer { list ->
            list?.let {
                adaptor.updateList(list)
            }


        })

        submitBtn.setOnClickListener {
            val noteText = input.text.toString()
            if(noteText.isNotEmpty()) {
                viewModel.insertNote(Note(noteText))
                Toast.makeText(this,"$noteText is inserted",Toast.LENGTH_SHORT).show()
            }
        }


    }

    override fun onItemClick(note: Note) {
        viewModel.deleteNote(note)
        Toast.makeText(this,"${note.text} is deleted",Toast.LENGTH_SHORT).show()
    }
}