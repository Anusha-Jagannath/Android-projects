package com.example.widgetexample

import android.app.Activity
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RemoteViews
import androidx.core.app.ActivityCompat
import com.example.widgetexample.databinding.ExampleWidgetConfigureBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

/**
 * The configuration screen for the [ExampleWidget] AppWidget.
 */
class ExampleWidgetConfigureActivity : Activity() {
    private var appWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID
    //private lateinit var appWidgetText: EditText
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var radioGroup: RadioGroup
   // private var widgetText: String = ""
    private var onClickListener = View.OnClickListener {
        val context = this@ExampleWidgetConfigureActivity

        radioGroup = findViewById(R.id.radioGroup)
        radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            var rb = findViewById<RadioButton>(i)
            if(rb != null) {
              //  widgetText = rb.text.toString()
            }
        }

        // When the button is clicked, store the string locally
        // val widgetText = appWidgetText.text.toString()
//        saveTitlePref(context, appWidgetId, widgetText)

        // It is the responsibility of the configuration activity to update the app widget
        val appWidgetManager = AppWidgetManager.getInstance(context)
        //updateAppWidget(context, appWidgetManager, appWidgetId)
        val buttonIntent = Intent(this, MainActivity::class.java)
        val buttonPendingIntent = PendingIntent.getActivity(this, 0, buttonIntent, 0)
        //val widgetText = appWidgetText.text.toString()

        val serviceIntent = Intent(this, ExampleWidgetService::class.java)
        serviceIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
        serviceIntent.setData(Uri.parse(serviceIntent.toUri(Intent.URI_INTENT_SCHEME)))

        //clicking the item in the adapter
        val clickIntent = Intent(this, ExampleWidget::class.java)
        clickIntent.setAction(ExampleWidget.ACTION_TOAST)
        val clickPendingIntent = PendingIntent.getBroadcast(this, 0, clickIntent, 0)


        val remoteViews = RemoteViews(this.packageName, R.layout.example_widget)
        remoteViews.setOnClickPendingIntent(R.id.exampleBtn, buttonPendingIntent)
        remoteViews.setCharSequence(R.id.exampleBtn, "setText", widgetText)
        remoteViews.setRemoteAdapter(R.id.example_widget_stack_view, serviceIntent)
        remoteViews.setEmptyView(R.id.example_widget_stack_view, R.id.example_widget_empty_view)
        remoteViews.setPendingIntentTemplate(R.id.example_widget_stack_view, clickPendingIntent)

        appWidgetManager.updateAppWidget(appWidgetId, remoteViews)
        saveTitlePref(context, appWidgetId, widgetText)

        // Make sure we pass back the original appWidgetId
        val resultValue = Intent()
        resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
        setResult(RESULT_OK, resultValue)
        finish()
    }
    private lateinit var binding: ExampleWidgetConfigureBinding

    public override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)

        // Set the result to CANCELED.  This will cause the widget host to cancel
        // out of the widget placement if the user presses the back button.
        setResult(RESULT_CANCELED)

        binding = ExampleWidgetConfigureBinding.inflate(layoutInflater)
        setContentView(binding.root)

       appWidgetText = binding.appwidgetText as EditText
        binding.addButton.setOnClickListener(onClickListener)

        // Find the widget id from the intent.
        val intent = intent
        val extras = intent.extras
        if (extras != null) {
            appWidgetId = extras.getInt(
                AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID
            )
        }


        // If this activity was started with an intent without an app widget ID, finish with an error.
        if (appWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
            finish()
            return
        }

        appWidgetText.setText(loadTitlePref(this@ExampleWidgetConfigureActivity, appWidgetId))

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        fetchLocation1()
    }

    private fun fetchLocation1() {
        val task = fusedLocationProviderClient.lastLocation

        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                101
            )
            return
        }
        task.addOnSuccessListener {
            if (it != null) {
                Log.d("LATITUDE", it.latitude.toString())
                Log.d("LONGITUDE", it.longitude.toString())
            } else {
                Log.d("LOCATION", "empty")
            }
        }
    }
}

const val PREFS_NAME = "com.example.widgetexample.ExampleWidget"
const val PREF_PREFIX_KEY = "appwidget_"

// Write the prefix to the SharedPreferences object for this widget
internal fun saveTitlePref(context: Context, appWidgetId: Int, text: String) {
    val prefs = context.getSharedPreferences(PREFS_NAME, 0).edit()
    prefs.putString(PREF_PREFIX_KEY + appWidgetId, text)
    prefs.apply()
}

// Read the prefix from the SharedPreferences object for this widget.
// If there is no preference saved, get the default from a resource
internal fun loadTitlePref(context: Context, appWidgetId: Int): String {
    val prefs = context.getSharedPreferences(PREFS_NAME, 0)
    val titleValue = prefs.getString(PREF_PREFIX_KEY + appWidgetId, null)
    return titleValue ?: context.getString(R.string.appwidget_text)
}

internal fun deleteTitlePref(context: Context, appWidgetId: Int) {
    val prefs = context.getSharedPreferences(PREFS_NAME, 0).edit()
    prefs.remove(PREF_PREFIX_KEY + appWidgetId)
    prefs.apply()
}