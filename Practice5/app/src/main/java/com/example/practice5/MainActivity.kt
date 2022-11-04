package com.example.practice5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practice5.models.ExampleSingleton
import com.example.practice5.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("DEBUG","${ExampleSingleton.singleUser.hashCode()}")
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.user.observe(this,Observer {
            println("DEBUG: $it")
        })

        viewModel.setUserId("1")

        println("DEBUG: ExampleSingleton: ${ExampleSingleton}")

    }
}