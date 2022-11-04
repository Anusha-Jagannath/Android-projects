package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(private val todo: ArrayList<Todo>): RecyclerView.Adapter<TodoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent,false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(todo[position])
    }

    override fun getItemCount(): Int {
       return todo.size
    }
}

class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val title = itemView.findViewById<AppCompatTextView>(R.id.title)
    private val isChecked = itemView.findViewById<CheckBox>(R.id.checkbox)

    fun bind(todo: Todo) {
        title.text = todo.title
        isChecked.isChecked = todo.isChecked
    }
}