package com.example.coroutineretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coroutineretrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment()
    }

    private fun replaceFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, CountryFragment())
            .commit()
    }
}