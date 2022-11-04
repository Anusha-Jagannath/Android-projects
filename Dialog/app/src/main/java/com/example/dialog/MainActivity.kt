package com.example.dialog

import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var button1:Button
    lateinit var button2:Button
    lateinit var button3:Button
    lateinit var button4:Button
    lateinit var text:EditText
    lateinit var dt: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1 = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        text = findViewById(R.id.displayText)


        button1.setOnClickListener {
            openAlert()
        }

        button2.setOnClickListener {
            openProgress()
        }

        button3.setOnClickListener {
            openDate()
        }


    }

    private fun openDate() {
        var c = Calendar.getInstance()
        var dp = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { datePicker, yy, mm, dd ->
                dt = "$dd/${mm+1}/$yy"
            },c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH))
        dp.show()
    }

    private fun openProgress() {
        var progressDialog = ProgressDialog(this)
        progressDialog.setTitle("downloading")
        progressDialog.setMessage("file downloading")
        progressDialog.max = 100
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
        progressDialog.show()

        Thread(Runnable {
            var count = 0
            while(count <= 100) {
                try {
                    progressDialog.progress = count
                    count += 10
                    Thread.sleep(1000)
                }
                catch (i:InterruptedException) {}
            }
            progressDialog.dismiss()
        }).start()

    }

    private fun openAlert() {
       var ad = AlertDialog.Builder(this)
        ad.setMessage("Are you enjoying?")
        ad.setTitle("Enjoying")
        ad.setPositiveButton("yes",DialogInterface.OnClickListener { dialogInterface, i ->
            Toast.makeText(applicationContext,"Thank you for your feedback",Toast.LENGTH_SHORT).show()
        })
        ad.setNegativeButton("No",DialogInterface.OnClickListener { dialogInterface, i ->
            Toast.makeText(applicationContext,"I will improve",Toast.LENGTH_SHORT).show()
        })
        ad.show()
    }
}