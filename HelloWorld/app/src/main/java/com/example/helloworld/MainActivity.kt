package com.example.helloworld

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.helloworld.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.selectBtn.setOnClickListener {
            clickDatePicker()
        }
    }

    private fun clickDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH) + 1
        val date = calendar.get(Calendar.DAY_OF_MONTH)
        val dp = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDay ->

                val date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                binding.selectedDateTv.text = date
                Toast.makeText(
                    this,
                    "$selectedYear $selectedDay $selectedMonth",
                    Toast.LENGTH_SHORT
                ).show()
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val theDate = sdf.parse(date)
                theDate.let {
                    val timeInMinutes = theDate.time / 60000
                    val currentTime = sdf.parse(sdf.format(System.currentTimeMillis()))

                    currentTime.let {
                        val currentTimeInMinutes = currentTime.time / 60000

                        val differenceInMinute = currentTimeInMinutes - timeInMinutes
                        binding.resultTv.text = differenceInMinute.toString()
                    }

                }
            },
            year,
            month,
            date
        )
        dp.datePicker.maxDate = System.currentTimeMillis() - 86400000
        dp.show()

    }
}
