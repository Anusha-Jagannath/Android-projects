package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataList = ArrayList<Data>()
        dataList.add(Data(gfgViewAdapter.THE_FIRST_VIEW, "1. Geeks View 1"))
        dataList.add(Data(gfgViewAdapter.THE_SECOND_VIEW, "2. Geeks View 2"))
        dataList.add(Data(gfgViewAdapter.THE_FIRST_VIEW, "3. Geeks View 3"))
        dataList.add(Data(gfgViewAdapter.THE_SECOND_VIEW, "4. Geeks View 4"))
        dataList.add(Data(gfgViewAdapter.THE_FIRST_VIEW, "5. Geeks View 5"))
        dataList.add(Data(gfgViewAdapter.THE_SECOND_VIEW, "6. Geeks View 6"))
        dataList.add(Data(gfgViewAdapter.THE_FIRST_VIEW, "7. Geeks View 7"))
        dataList.add(Data(gfgViewAdapter.THE_SECOND_VIEW, "8. Geeks View 8"))
        dataList.add(Data(gfgViewAdapter.THE_FIRST_VIEW, "9. Geeks View 9"))
        dataList.add(Data(gfgViewAdapter.THE_SECOND_VIEW, "10. Geeks View 10"))
        dataList.add(Data(gfgViewAdapter.THE_FIRST_VIEW, "11. Geeks View 11"))
        dataList.add(Data(gfgViewAdapter.THE_SECOND_VIEW, "12. Geeks View 12"))

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = gfgViewAdapter(this,dataList)
        binding.recyclerView.adapter = adapter


    }
}