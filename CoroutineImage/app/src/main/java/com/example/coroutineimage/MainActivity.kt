package com.example.coroutineimage

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.coroutineimage.databinding.ActivityMainBinding
import com.example.coroutineimage.filter.Filter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.net.URL

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val imageUrl =
        "https://images.unsplash.com/photo-1646673940197-dbf528eea559?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1770&q=80"
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        coroutineScope.launch {
            val originalDeferred = coroutineScope.async(Dispatchers.IO) { getBitmap() }
            val originalBitmap = originalDeferred.await()
            loadImage(originalBitmap)

            val filteredDeferred = coroutineScope.async(Dispatchers.Default) { applyFilter(originalBitmap) }
            val output= filteredDeferred.await()
            loadImage(output)

        }

    }

    private fun getBitmap(): Bitmap {
        URL(imageUrl).openStream().use {
            return BitmapFactory.decodeStream(it)
        }
    }

    private fun loadImage(bitmap: Bitmap) {
        binding.progressBar.visibility = View.GONE
        binding.imageView.setImageBitmap(bitmap)
        binding.imageView.visibility = View.VISIBLE
    }

    private fun applyFilter(bitmap: Bitmap) = Filter.apply(bitmap)
}