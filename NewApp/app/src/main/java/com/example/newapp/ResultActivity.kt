package com.example.newapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var userName = intent.getStringExtra(Constant.USER_NAME)
        var totalQuestions = intent.getIntExtra(Constant.TOTAL_QUESTIONS,0)
        var correctAnswers = intent.getIntExtra(Constant.CORRECT_ANSWERS,0)
        binding.userName.text = userName
        binding.scoreTv.text = "Your score is $correctAnswers out of $totalQuestions"
        binding.submitBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}