package com.example.practice4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView

class NotesRVAdapter(private val context: Context, private val listener: INotesRVAdapter) :
    RecyclerView.Adapter<NotesViewHolder>() {
    private val allNotes: ArrayList<Note> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.note_item, parent, false)
        val viewHolder = NotesViewHolder(itemView)
        viewHolder.deleteBtn.setOnClickListener {
            listener.onItemClick(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder

    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {

        val currentNote = allNotes[position]
        holder.ttext.text = currentNote.text

    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    fun updateAdapter(noteList: List<Note>) {
        allNotes.clear()
        allNotes.addAll(noteList)
        notifyDataSetChanged()
    }
}

class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val ttext = itemView.findViewById<AppCompatTextView>(R.id.text)
    val deleteBtn = itemView.findViewById<Button>(R.id.btn)


}

interface INotesRVAdapter {
    fun onItemClick(note: Note)
}