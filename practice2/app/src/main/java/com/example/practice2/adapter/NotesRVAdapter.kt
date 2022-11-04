package com.example.practice2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practice2.model.Note

class NotesRVAdapter(val context: Context,val listener: INotesRVAdapter): RecyclerView.Adapter<NotesViewHolder>() {

    val allNotes = arrayListOf<Note>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.note_item,parent,false)
        val viewHolder = NotesViewHolder(view)
        viewHolder.deleteBtn.setOnClickListener {
            listener.onItemClick(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder

    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val currentNote = allNotes[position]
        holder.noteText.text = currentNote.text
    }

    override fun getItemCount(): Int {
      return allNotes.size
    }

    fun updateList(newList: List<Note>) {
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }
}
class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val noteText: TextView = itemView.findViewById(R.id.noteTv)
    val deleteBtn: ImageView = itemView.findViewById(R.id.deleteBtn)
}

interface INotesRVAdapter {
    fun onItemClick(note: Note)

}