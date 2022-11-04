package com.example.newapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.example.newapp.databinding.QuestionLayoutBinding

class QuestionActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: QuestionLayoutBinding
    private var mQuestionList = arrayListOf<Question>()
    private var mCurrentPosition: Int = 1
    private var mSelectedPosition: Int = 0
    private var mUserName: String? = null
    private var mCorrectAnswers: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = QuestionLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mUserName = intent.getStringExtra(Constant.USER_NAME)
        mQuestionList = Constant.getQuestions()
        Log.e("QuestionList", mQuestionList.toString())
        binding.tvOption1.setOnClickListener(this)
        binding.tvOption2.setOnClickListener(this)
        binding.tvOption3.setOnClickListener(this)
        binding.tvOption4.setOnClickListener(this)
        binding.submitBtn.setOnClickListener(this)
        setQuestion()
    }

    private fun setQuestion() {
        setDefaultBackground()
        val currentQuestion = mQuestionList[mCurrentPosition - 1]
        binding.tvQuestion.text = currentQuestion.question
        binding.image.setImageResource(currentQuestion.image)
        binding.progressbar.progress = mCurrentPosition
        binding.tvProgressbar.text = "$mCurrentPosition/6"
        binding.tvOption1.text = currentQuestion.optionOne
        binding.tvOption2.text = currentQuestion.optionTwo
        binding.tvOption3.text = currentQuestion.optionThree
        binding.tvOption4.text = currentQuestion.optionFour

        if (mCurrentPosition == mQuestionList.size) {
            binding.submitBtn.text = "FINISH"
        } else {
            binding.submitBtn.text = "SUBMIT"
        }
    }

    private fun setDefaultBackground() {
        val textViews = arrayListOf<AppCompatTextView>()

        textViews.add(binding.tvOption1)
        textViews.add(binding.tvOption2)
        textViews.add(binding.tvOption3)
        textViews.add(binding.tvOption4)

        for (textView in textViews) {
            textView.background = ContextCompat.getDrawable(this, R.drawable.default_background)
            textView.setTextColor(Color.parseColor("#000000"))
            textView.typeface = Typeface.DEFAULT
        }
    }

    private fun setSelectedBackground(view: AppCompatTextView, selectedPosition: Int) {
        mSelectedPosition = selectedPosition
        view.background = ContextCompat.getDrawable(this, R.drawable.selected_background)
        view.setTextColor(Color.parseColor("#FF000000"))
        view.typeface = Typeface.DEFAULT_BOLD
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv_option1 -> {
                setSelectedBackground(view as AppCompatTextView, 1)
            }
            R.id.tv_option2 -> {
                setSelectedBackground(view as AppCompatTextView, 2)
            }
            R.id.tv_option3 -> {
                setSelectedBackground(view as AppCompatTextView, 3)
            }
            R.id.tv_option4 -> {
                setSelectedBackground(view as AppCompatTextView, 4)
            }
            R.id.submit_btn -> {
                Toast.makeText(this,"clicked",Toast.LENGTH_SHORT).show()
                if (mSelectedPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionList.size -> {
                            setQuestion()
                        }
                        else -> {
                            Toast.makeText(this@QuestionActivity,"You reached the end", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constant.USER_NAME,mUserName)
                            intent.putExtra(Constant.TOTAL_QUESTIONS, mQuestionList.size)
                            intent.putExtra(Constant.CORRECT_ANSWERS,mCorrectAnswers)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionList[mCurrentPosition-1]
                    if (mSelectedPosition != question.correctAnswer) {
                        answerView(mSelectedPosition, R.drawable.wrong_answer_background)
                    } else {
                        mCorrectAnswers = mCorrectAnswers + 1
                    }
                        answerView(question.correctAnswer, R.drawable.correct_answer_background)

                    if (mCurrentPosition == mQuestionList.size) {
                        binding.submitBtn.text = "FINISH"
                    } else {
                        binding.submitBtn.text = "GOTO NEXT QUESTION"
                    }
                    mSelectedPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {

        when(answer) {
            1 -> {
                binding.tvOption1.background = ContextCompat.getDrawable(this@QuestionActivity, drawableView)
            }
            2 -> {
                binding.tvOption2.background = ContextCompat.getDrawable(this@QuestionActivity, drawableView)
            }
            3 -> {
                binding.tvOption3.background = ContextCompat.getDrawable(this@QuestionActivity, drawableView)
            }
            4 -> {
                binding.tvOption4.background = ContextCompat.getDrawable(this@QuestionActivity, drawableView)
            }
        }

    }

}