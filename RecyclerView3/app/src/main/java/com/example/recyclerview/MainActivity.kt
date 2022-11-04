package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var list = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        list = getData()
        val adapter = TextAdapter(list)
        binding.recyclerView.adapter = adapter
    }

    fun getData(): ArrayList<String> {
        val list = arrayListOf<String>()

        for( i in 0..100) {
            list.add("Item added $i")
        }
        return list
    }
}