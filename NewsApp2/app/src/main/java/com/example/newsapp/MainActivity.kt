package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val items = fetchData()
        val adapter = NewsListAdapter(items)
        binding.recyclerView.adapter = adapter


    }

    private fun fetchData(): ArrayList<String> {
        val list = arrayListOf<String>()
        for( i in 1..100)
            list.add("Item $i")
        return list
    }
}