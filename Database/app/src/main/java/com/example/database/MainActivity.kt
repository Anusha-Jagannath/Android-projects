package com.example.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var id: EditText
    lateinit var name: EditText
    lateinit var insert: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        id = findViewById(R.id.inputId)
        name = findViewById(R.id.inputName)
        insert = findViewById(R.id.button)
        insert.setOnClickListener {
            var inputId = id.text.toString()
            var inputName = id.text.toString()

        }

    }
}