package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyNewAdapter(private val todo: List<Todo>): RecyclerView.Adapter<MyNewViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyNewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item,parent,false)
        return MyNewViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyNewViewHolder, position: Int) {
       holder.bind(todo[position])
    }

    override fun getItemCount(): Int {
       return todo.size
    }
}

class MyNewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val titleText = itemView.findViewById<TextView>(R.id.title)
    val checkBox = itemView.findViewById<CheckBox>(R.id.checkbox)

    fun bind(todo: Todo) {
        titleText.text = todo.title
        checkBox.isChecked = todo.checkbox
    }
}