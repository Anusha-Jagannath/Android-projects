package com.example.widgetexample

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.location.LocationManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RemoteViews
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.content.ContextCompat.startActivity

/**
 * Implementation of App Widget functionality.
 * App Widget Configuration implemented in [ExampleWidgetConfigureActivity]
 */
class ExampleWidget : AppWidgetProvider() {

    private lateinit var locationManager: LocationManager
    companion object {
        val ACTION_TOAST = "actionToast"
        val EXTRA_ITEM_POSITION = "extraItemPosition"

    }

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            //updateAppWidget(context, appWidgetManager, appWidgetId)
            var buttonIntent = Intent(context, MainActivity::class.java)
            var buttonPendingIntent = PendingIntent.getActivity(context, 0, buttonIntent, 0)

            val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            val titleValue = prefs.getString(PREF_PREFIX_KEY + appWidgetId, "press me")

            val serviceIntent = Intent(context, ExampleWidgetService::class.java)
            serviceIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
            serviceIntent.setData(Uri.parse(serviceIntent.toUri(Intent.URI_INTENT_SCHEME)))

            //adapter clicking on each item
            val clickIntent = Intent(context, ExampleWidget::class.java)
            clickIntent.setAction(ACTION_TOAST)
            val clickPendingIntent = PendingIntent.getBroadcast(context, 0, clickIntent, 0)

            var views = RemoteViews(context.packageName, R.layout.example_widget)
            views.setOnClickPendingIntent(R.id.exampleBtn, buttonPendingIntent)
            views.setCharSequence(R.id.exampleBtn, "setText", titleValue)
            views.setRemoteAdapter(R.id.example_widget_stack_view, serviceIntent)
            views.setEmptyView(R.id.example_widget_stack_view, R.id.example_widget_empty_view)

            views.setPendingIntentTemplate(R.id.example_widget_stack_view, clickPendingIntent)

            appWidgetManager.updateAppWidget(appWidgetId, views)
            Log.d("test", "widget")
        }
    }

    override fun onDeleted(context: Context, appWidgetIds: IntArray) {
        // When the user deletes the widget, delete the preference associated with it.
        for (appWidgetId in appWidgetIds) {
            deleteTitlePref(context, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
        Toast.makeText(context, "on enabled", Toast.LENGTH_LONG).show()
        Log.d("ENABLED", "on enabled called")
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
        Toast.makeText(context, "on disabled", Toast.LENGTH_SHORT).show()
        Log.d("DISABLED", "on disabled called")
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        super.onReceive(context, intent)
        if (ACTION_TOAST.equals(intent?.action)) {
            val clickedPosition = intent?.getIntExtra(EXTRA_ITEM_POSITION, 0)
            Log.d("POSITION", clickedPosition.toString())
//            var buttonIntent = Intent(context, MainActivity::class.java)
//            var buttonPendingIntent = PendingIntent.getActivity(context, 0, buttonIntent, 0)
//            var views = RemoteViews(context?.packageName, R.layout.example_widget_item)
//            views.setOnClickPendingIntent(R.id.example_widget_item_text, buttonPendingIntent)

            val appWidgetManager = AppWidgetManager.getInstance(context)
            appWidgetManager.notifyAppWidgetViewDataChanged(
                appWidgetManager.getAppWidgetIds(
                    context?.let { ComponentName(it, MainActivity::class.java) }
                ),
                R.id.example_widget_item_text
            )
        }
    }

    override fun onAppWidgetOptionsChanged(
        context: Context?,
        appWidgetManager: AppWidgetManager?,
        appWidgetId: Int,
        newOptions: Bundle?
    ) {
        var views = RemoteViews(context!!.packageName, R.layout.example_widget)
        var minWidth = newOptions?.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_WIDTH)
        var maxWidth = newOptions?.getInt(AppWidgetManager.OPTION_APPWIDGET_MAX_WIDTH)

        var minHeight = newOptions?.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_HEIGHT)
        var maxHeight = newOptions?.getInt(AppWidgetManager.OPTION_APPWIDGET_MAX_HEIGHT)

        var dimension =
            "Min width: $minWidth  Max width: $maxWidth  Min Height: $minHeight  Max Height:  $maxHeight"
        Log.d("DIMENSIONS", dimension)

        if (maxHeight != null) {
            if (maxHeight > 100) {
                Log.d("TYU", "TEST")
                views.setViewVisibility(R.id.tv_widget, View.VISIBLE)
                views.setViewVisibility(R.id.exampleBtn, View.VISIBLE)
            } else {
                views.setViewVisibility(R.id.tv_widget, View.GONE)
                views.setViewVisibility(R.id.exampleBtn, View.GONE)
            }
        }


    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
//    val widgetText = loadTitlePref(context, appWidgetId)
//    // Construct the RemoteViews object
//    val views = RemoteViews(context.packageName, R.layout.example_widget)
//    views.setTextViewText(R.id.appwidget_text, widgetText)
//
//    // Instruct the widget manager to update the widget
//    appWidgetManager.updateAppWidget(appWidgetId, views)
}