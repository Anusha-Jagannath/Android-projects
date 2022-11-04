package com.example.newapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.newapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.saveButton.setOnClickListener {
            val name = binding.nameText.text
            if (name.isNullOrEmpty()) {
                Toast.makeText(this,"please enter name",Toast.LENGTH_SHORT).show()
            }

            else {
               val intent = Intent(this, QuestionActivity::class.java)
                intent.putExtra(Constant.USER_NAME,name)
                startActivity(intent)
            }
        }
    }
}