package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val todoList = arrayListOf<Todo>()
    private lateinit var adapter: TodoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        adapter = TodoAdapter(todoList)
        binding.recyclerview.adapter = adapter

        binding.submitButton.setOnClickListener {
            val text = binding.editText.text.toString()
            if (text.isNotEmpty()) {
                val todo = Todo(text, false)
                todoList.add(todo)
                adapter.notifyItemInserted(todoList.size)
            }
        }
    }
}