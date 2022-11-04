package com.example.keyboard

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.keyboard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
        showSoftKeyBoard2(this, binding.editTest)
    }

    private fun showSoftKeyBoard2(activity: MainActivity, editTest: EditText) {
     val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editTest, InputMethodManager.SHOW_IMPLICIT)
        editTest.requestFocus()
    }

    fun showSoftKeyBoard(activity: Activity?, mInputerEditTxt: EditText?) {
        if (activity != null && mInputerEditTxt != null) {
            val imm = activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(mInputerEditTxt, InputMethodManager.SHOW_IMPLICIT)
            mInputerEditTxt.requestFocus()
        }
    }

}