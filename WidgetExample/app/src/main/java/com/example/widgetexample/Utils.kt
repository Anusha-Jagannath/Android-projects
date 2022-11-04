package com.example.widgetexample

import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient

class Utils() {

    fun fetchLocation(context: ExampleWidgetConfigureActivity, fusedLocationProviderClient: FusedLocationProviderClient,) {
        val task = fusedLocationProviderClient.lastLocation

        if (ActivityCompat.checkSelfPermission(
                context,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                context,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                context,
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

    fun fetchLocation1(exampleWidgetConfigureActivity: ExampleWidgetConfigureActivity, fusedLocationProviderClient: FusedLocationProviderClient) {

    }
}