package com.example.firebasecrud

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var sharedPreference:SharedPreferences
    lateinit var name:EditText
    lateinit var age:EditText
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name = findViewById(R.id.editTextTextPersonName)
        age = findViewById(R.id.editTextTextPersonName2)
        button = findViewById(R.id.button)

        sharedPreference = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        button.setOnClickListener {
            val userName = name.editableText.toString()
            val age = age.editableText.toString()
            val editor: SharedPreferences.Editor = sharedPreference.edit()
            editor.putString("NAME",userName)
            editor.putString("AGE",age)
            editor.apply()
            Toast.makeText(this,"information saved",Toast.LENGTH_LONG).show()
            Toast.makeText(this,"information $editor",Toast.LENGTH_LONG).show()

        }
    }
}