package com.example.sharedpreference

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreference: SharedPreferences
    lateinit var name: EditText
    lateinit var age: EditText
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.editTextTextPersonName)
        age = findViewById(R.id.editTextTextPersonName2)
        button = findViewById(R.id.button)

        loadLocale()
        setLocale("hi")



        }

    private fun setLocale(lang: String) {
        var locale = Locale(lang)
        Locale.setDefault(locale)
        var config = Configuration()
        config.locale = locale
        baseContext.resources.updateConfiguration(config,baseContext.resources.displayMetrics)

        val sharedPreferences = getSharedPreferences("settings", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("lang", lang)
        editor.apply()
    }

    fun loadLocale() {
        val sharedPreferences = getSharedPreferences("settings", MODE_PRIVATE)
        val language = sharedPreferences.getString("lang", "")
        if (language != null) {
            Log.d("HOME LANGUAGE",language)
        }

        if (language != null) {
            setLocale(language)
        }
    }




    }
