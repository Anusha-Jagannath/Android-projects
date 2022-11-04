package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.quizapp.databinding.ActivityQuizQuestionBinding

class QuizQuestionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizQuestionBinding
    private lateinit var questionList: ArrayList<Question>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        questionList = Constants.getQuestions()
        Log.d("QuestionList",questionList.toString())
        setQuestion()
    }

    private fun setQuestion() {
        val currentPosition = 0
        val currentQuestion = questionList[currentPosition]
        binding.tvQuestion.text = currentQuestion.question
        binding.image.setImageResource(currentQuestion.image)
        binding.progressbar.progress = currentPosition
        binding.tvCount.text = "$currentPosition/${binding.progressbar.max}"
        binding.tvOption1.text = currentQuestion.optionOne
        binding.tvOption2.text = currentQuestion.optionTwo
        binding.tvOption3.text = currentQuestion.optionThree
        binding.tvOption4.text = currentQuestion.optionFour
    }
}