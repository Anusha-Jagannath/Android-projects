package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.calculator.databinding.ActivityMainBinding
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var lastNumeric: Boolean = false
    var lastDot: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)


    }

    fun onDigit(view: View) {
        binding.inputTv.apply {
            append((view as Button).text)
            lastNumeric = true
            val sentence = "Dennis learns"
        }
    }

    fun onClear(view: View) {
        binding.inputTv.apply {
            text = ""
        }
    }

    fun onDecimalPoint(view: View) {
        if (!lastDot && lastNumeric) {
            binding.inputTv.append((view as Button).text)
            lastDot = true
            lastNumeric = false
        }
    }

    fun onOperator(view: View) {
        binding.inputTv.let {
            if (lastNumeric && !isOperatorAdded(it.text.toString())) {
                it.append((view as Button).text)
                lastNumeric = false
                lastDot = false
            }
        }
    }

    fun onEqual(view: View) {
        if (lastNumeric) {
            var tvValue = binding.inputTv.text.toString()
            var prefix = ""
            try {
                if (tvValue.startsWith("-")) {
                    prefix = "-"
                    tvValue = tvValue.substring(1)
                }

                if (tvValue.contains("-")) {
                    val splitValue = tvValue.split("-")
                    var one = splitValue[0]
                    var two = splitValue[1]
                    if (prefix.isNotEmpty()) {
                        one = prefix + one
                    }
                    binding.inputTv.text = removeZeroAfterDot((one.toDouble() - two.toDouble()).toString())
                } else if (tvValue.contains("+")) {
                    val splitValue = tvValue.split("+")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if (prefix.isNotEmpty()) {
                        one = prefix + one
                    }
                    binding.inputTv.text = removeZeroAfterDot((one.toDouble() + two.toDouble()).toString())

                } else if (tvValue.contains("*")) {
                    val splitValue = tvValue.split("*")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if (prefix.isNotEmpty()) {
                        one = prefix + one
                    }
                    binding.inputTv.text = removeZeroAfterDot((one.toDouble() * two.toDouble()).toString())

                } else if (tvValue.contains("/")) {
                    val splitValue = tvValue.split("/")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if (prefix.isNotEmpty()) {
                        one = prefix + one
                    }
                    binding.inputTv.text = removeZeroAfterDot((one.toDouble() / two.toDouble()).toString())

                }


            } catch (exception: ArithmeticException) {
                exception.printStackTrace()
            }
        }
    }

    private fun removeZeroAfterDot(input: String): String {

        var result = input
        if (result.contains(".0")) {
            result = result.substring(0, result.length - 2)
        }
        return result
    }

    private fun isOperatorAdded(value: String): Boolean {
        return if (value.startsWith("-")) false
        else {
            value.contains("/") || value.contains("*") || value.contains("+")
                    || value.contains("-")
        }
    }
}