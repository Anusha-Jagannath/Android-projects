package com.example.scoreapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private val SCORE = "score"
    private lateinit var scoreTextView: TextView
    private lateinit var incrementButton: FloatingActionButton
    private var score = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        scoreTextView = findViewById(R.id.textView_score)
        incrementButton = findViewById(R.id.button_increment)

        savedInstanceState?.let {
            score = it.getInt(SCORE)
            scoreTextView.text = score.toString()
        }
        incrementButton.setOnClickListener {
            scoreTextView.text = (++score).toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(SCORE,score)
        super.onSaveInstanceState(outState)
    }
}