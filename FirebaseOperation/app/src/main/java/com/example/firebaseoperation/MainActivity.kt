package com.example.firebaseoperation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth




class MainActivity : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null
    lateinit var name:EditText
    lateinit var age:EditText
    lateinit var btn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name = findViewById(R.id.editTextName)
        age = findViewById(R.id.editTextAge)
        btn = findViewById(R.id.button)
        btn.setOnClickListener {
            var input1 = name.editableText.toString()
            var input2 = age.editableText.toString()
            mAuth = FirebaseAuth.getInstance();
            registerUser(name,age)
        }

    }

    private fun registerUser(name: EditText, age: EditText) {

    }
}