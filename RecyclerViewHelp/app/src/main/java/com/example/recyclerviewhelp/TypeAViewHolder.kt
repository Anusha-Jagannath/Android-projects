package com.example.recyclerviewhelp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TypeAViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val text = itemView.findViewById<TextView>(R.id.typeATv)
}