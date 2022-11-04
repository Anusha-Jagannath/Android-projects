package com.example.agetominutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.agetominutes.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.clickBtn.setOnClickListener {
            pickDate()

        }

    }

    private fun pickDate() {
        Log.d("btn","clicked")
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val date = cal.get(Calendar.DAY_OF_MONTH)
        val dp = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view,selectedYear,selectedMonth,selectedDay ->
            val selectedDate = "$selectedDay/${selectedMonth+1}/$selectedYear"
            binding.selectedAgeTv.text = selectedDate

            val dateFormat = SimpleDateFormat("dd/MM/yyy",Locale.ENGLISH)
            val dateObject = dateFormat.parse(selectedDate)
            dateObject?.let {
                val selectedDateInMinutes = dateObject.time / 60000
                val currentDate = dateFormat.parse(dateFormat.format(System.currentTimeMillis()))
                currentDate?.let {
                    val currentDateInMinutes = currentDate.time / 60000
                    val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes
                    binding.resultTv.text = differenceInMinutes.toString()
                }
            }

        },year,month,date)
        dp.datePicker.maxDate = System.currentTimeMillis() - 86400000
        dp.show()
    }
}