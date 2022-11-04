package com.example.rec

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(private val todoList: List<Todo>): RecyclerView.Adapter<TodoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo,parent,false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currentTodo = todoList[position]
        holder.bind(currentTodo)
    }

    override fun getItemCount(): Int {
        return todoList.size
    }
}

class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(currentTodo: Todo) {
        val textTv = itemView.findViewById<TextView>(R.id.tvTitle)
        val checkBox = itemView.findViewById<CheckBox>(R.id.checkBox)
        textTv.text = currentTodo.title
        checkBox.isChecked = currentTodo.isChecked
    }
}