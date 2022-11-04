package com.example.facebook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

open class MainActivity : AppCompatActivity() {
    lateinit var imageBtn: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageBtn = findViewById(R.id.imageView2)
        imageBtn.setOnClickListener {
            Toast.makeText(this,"Button clicked",Toast.LENGTH_SHORT).show()
        }


    }
}