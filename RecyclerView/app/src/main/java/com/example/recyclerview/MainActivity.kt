package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var todo = arrayListOf<Todo>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//        val adapter = SuckAdapter()
//        binding.recyclerView.adapter = adapter

        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        val adapter = MyNewAdapter(todo)
        binding.recyclerview.adapter = adapter

        binding.submit.setOnClickListener {
            val text = binding.input.text.toString()
            val todo = Todo(text, false)
            adapter.notifyItemChanged(todo.)

        }
    }
}