package com.example.myapp11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    lateinit var name:EditText
    lateinit var age:EditText
    lateinit var btn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = Firebase.auth
        name = findViewById(R.id.personName)
        age = findViewById(R.id.personAge)
        btn.setOnClickListener {

            registerUser(name,age)
        }

    }
    
    private fun registerUser(name: EditText, age: EditText) {
        var name1 = name.editableText.toString()
        var age1 = name.editableText.toString()
    }
}