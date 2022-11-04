package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView

class NotessAdapter(private val notessList: ArrayList<Notess>): RecyclerView.Adapter<NotessViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotessViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item1_note, parent, false)
        return NotessViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotessViewHolder, position: Int) {
       holder.bind(notessList[position])
    }

    override fun getItemCount(): Int {
      return notessList.size
    }
}

class NotessViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val title = itemView.findViewById<AppCompatTextView>(R.id.title)
    private val isChecked = itemView.findViewById<CheckBox>(R.id.checkbox)
    fun bind(note: Notess) {
        title.text = note.title
        isChecked.isChecked = note.isChecked
    }
}