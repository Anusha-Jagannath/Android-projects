package com.example.widgetexample

import android.app.Activity
import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.SystemClock
import android.util.Log
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import androidx.core.app.ActivityCompat
import com.example.widgetexample.ExampleWidget.Companion.EXTRA_ITEM_POSITION
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.text.DateFormat
import java.util.*

class ExampleWidgetService : RemoteViewsService() {
    override fun onGetViewFactory(p0: Intent): RemoteViewsFactory {
        return ExampleWidgetItemFactory(applicationContext, p0)
    }

    class ExampleWidgetItemFactory(context: Context, intent: Intent) : RemoteViewsFactory {
        private var appWidgetIds: Int = AppWidgetManager.INVALID_APPWIDGET_ID
        private var context: Context = context
        private var exampleData =
            arrayOf<String>("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")


        init {
            this.appWidgetIds = intent.getIntExtra(
                AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID
            )
        }

        override fun onCreate() {
            //this will be triggered when you instantiate first ExampleWidgetItemFactory
            //should not do heavy operations here as it freezes your app
            //connect to data source
            SystemClock.sleep(3000)

        }

        private fun fetchLocation(context: Context) {


        }

        override fun onDataSetChanged() {
            //is used when we want to update the widget
            //refresh 
            val date = Date()
            val formattedTime = DateFormat.getTimeInstance(DateFormat.SHORT).format(date)
            exampleData = arrayOf("one\n$formattedTime two\n$formattedTime three\n$formattedTime")


        }

        override fun onDestroy() {
            //close data source
        }

        override fun getCount(): Int {
            return exampleData.size
        }

        override fun getViewAt(p0: Int): RemoteViews {
            val remoteViews = RemoteViews(context.packageName, R.layout.example_widget_item)
            remoteViews.setTextViewText(R.id.example_widget_item_text, exampleData[p0])
            val fillIntent = Intent()
            fillIntent.putExtra(EXTRA_ITEM_POSITION, p0)
            remoteViews.setOnClickFillInIntent(R.id.example_widget_item_text, fillIntent)
            SystemClock.sleep(500)
            return remoteViews
        }

        override fun getLoadingView(): RemoteViews? {
            return null
        }

        override fun getViewTypeCount(): Int {
            return 1
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun hasStableIds(): Boolean {
            return true
        }

    }
}