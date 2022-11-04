package com.example.keyboarddemo

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.keyboarddemo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //binding.input.requestFocus()

        binding.input.setOnTouchListener { _, event ->
            if (MotionEvent.ACTION_UP == event.action) {
               Log.d("Touch listener","listener")
                //binding.input.isFocusable = false
            }
            return@setOnTouchListener false
        }



        binding.input.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                binding.input.isFocusable = false
                Log.d("Focus listener","focus change")
                Toast.makeText(this,"edit text has focus",Toast.LENGTH_SHORT).show()
            }
        }
        binding.input.setOnClickListener {
            Log.d("Click listener","click listener")
        }
    }

    fun showKeyboard(activity: Activity?, mInputerEditTxt: EditText?) {
        if (activity != null && mInputerEditTxt != null) {
            val imm = activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(mInputerEditTxt, InputMethodManager.SHOW_IMPLICIT)
        }
    }

    fun hideKeyboard(activity: Activity?) {
        if (activity != null && activity.currentFocus != null) {
            val imm = activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        }
    }
}