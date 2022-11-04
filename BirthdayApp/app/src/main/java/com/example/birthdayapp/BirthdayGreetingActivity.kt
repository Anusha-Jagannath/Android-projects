package com.example.birthdayapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class BirthdayGreetingActivity : AppCompatActivity() {
    private lateinit var birthdayGreetingsTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birthday_greeting)
        birthdayGreetingsTextView = findViewById(R.id.birthdayGreeting)
        val name = intent.getStringExtra(Constants.NAME)
        birthdayGreetingsTextView.text = "Happy Birthday $name !!"

    }
}