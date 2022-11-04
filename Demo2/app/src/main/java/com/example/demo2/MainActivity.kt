package com.example.demo2

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.work.*
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    lateinit var editText1: EditText
    lateinit var editText2: EditText
    lateinit var button: Button
    lateinit var datePicker: DatePicker
    lateinit var timePicker: TimePicker
    var HOUR: Int = 0
    var MIN: Int = 0
     var YEAR: Int = 0
     var MM: Int = 0
      var DAY: Int = 0


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText1 = findViewById(R.id.editTextTextPersonName)
        editText2 = findViewById(R.id.editTextTextPersonName2)
        datePicker = findViewById(R.id.datePicker)
        timePicker = findViewById(R.id.timePicker)
        button = findViewById(R.id.btn)
        button.setOnClickListener {
             Toast.makeText(this,"button clicked",Toast.LENGTH_SHORT).show()
               var time = getTime()
              Log.d("TIMER",time.toString())
        }


        myWorkManager()

    }

    private fun myWorkManager() {
        val constraints = Constraints.Builder()
            .setRequiresCharging(false)
            .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
            .setRequiresCharging(false)
            .setRequiresBatteryNotLow(true)
            .build()

        val myRequest = PeriodicWorkRequest.Builder(
            MyWorker::class.java,2, TimeUnit.MINUTES
        ).setConstraints(constraints).build()

        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "my_id",ExistingPeriodicWorkPolicy.KEEP,myRequest
        )
    }

    private fun simpleWork() {
        val mRequest:WorkRequest = OneTimeWorkRequestBuilder<MyWorker>()
            .build()
        WorkManager.getInstance(this)
            .enqueue(mRequest)

    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun getTime(): Long {
        val minute = timePicker.minute
        val hour = timePicker.hour
        val day = datePicker.dayOfMonth
        val month = datePicker.month
        val year = datePicker.year

        HOUR = hour
        MIN = minute
        DAY = day
        MM=month
        YEAR=year

        val calendar = Calendar.getInstance()
        calendar.set(YEAR,MM,DAY,HOUR,MM)
        return calendar.timeInMillis

    }
}