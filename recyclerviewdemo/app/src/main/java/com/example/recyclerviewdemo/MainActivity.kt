package com.example.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        val list = getData()
        val adapter = NewsAdapter(list)
        binding.recyclerview.adapter = adapter
    }

    private fun getData(): ArrayList<String>{
        var list = arrayListOf<String>()
        for(i in 0..100) {
            list.add("Item $i")
        }
        return list
    }
}