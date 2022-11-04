package com.example.birthdayapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var name: EditText
    private lateinit var submitButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name = findViewById(R.id.editTextName)
        submitButton = findViewById(R.id.submit)
        submitButton.setOnClickListener {
            val inputName = name.text.toString()
            if(inputName.isNotEmpty()){
                val intent = Intent(this,BirthdayGreetingActivity::class.java)
                intent.putExtra(Constants.NAME,inputName)
                startActivity(intent)
            }
            else {
                Toast.makeText(this@MainActivity,"please enter valid name",Toast.LENGTH_SHORT).show()
            }
        }
    }
}