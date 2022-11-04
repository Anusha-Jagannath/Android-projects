package com.example.demoapp

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateFormat.getLongDateFormat
import android.util.Log
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import com.google.android.material.timepicker.TimeFormat
import java.text.DateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var editText1: EditText
    lateinit var editText2: EditText
    lateinit var datePicker1: DatePicker
    lateinit var timePicker2: TimePicker
    lateinit var button: Button
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText1 = findViewById(R.id.editTextTextPersonName)
        editText2 = findViewById(R.id.editTextTextPersonName2)
        datePicker1 = findViewById(R.id.datePicker)
        timePicker2 = findViewById(R.id.timePicker)
        button = findViewById(R.id.btn)
        createNotificationChannel()
        button.setOnClickListener {
            scheduleNotification()
        }

    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun scheduleNotification() {
      val intent = Intent(applicationContext,Notification::class.java)
        val title = editText1.text.toString()
        val message = editText2.text.toString()
        intent.putExtra(titleExtra,title)
       intent.putExtra(messageExtra,message)

        val pendingIntent = PendingIntent.getBroadcast(
            applicationContext, notificationID,intent,PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val time = getTime()
        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,time,pendingIntent
        )
        showAlert(time,title,message)

    }

    private fun showAlert(time: Long, title: String, message: String) {
        val date = Date(time)
        val dateFormat = android.text.format.DateFormat.getLongDateFormat(applicationContext)
        val timeFormat = android.text.format.DateFormat.getTimeFormat(applicationContext)
        AlertDialog.Builder(this)
            .setTitle("Notification scheduled").
            setMessage("Title:"+title+"Message"+message+"At: "+dateFormat.format(date)+" "+timeFormat.format(time))
            .setPositiveButton("Okay",null)
            .show()

    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun getTime(): Long {
        val minute = timePicker2.minute
        val hour = timePicker2.hour
        val day = datePicker1.dayOfMonth
        val month = datePicker1.month
        val year = datePicker1.year
        Log.d("MIN",minute.toString())
        Log.d("HR",hour.toString())

        Log.d("DAY",day.toString())
        Log.d("MONTH",month.toString())
        Log.d("YEAR",year.toString())


        val calendar = Calendar.getInstance()
        calendar.set(year,month,day,hour,minute)
        Log.d("TIMEINMILL",calendar.timeInMillis.toString())
        return calendar.timeInMillis

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel() {
       val name = "Notif_channel"
        val desc = " A description of channel"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(channelId,name,importance)
        channel.description = desc
       val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)

    }
}