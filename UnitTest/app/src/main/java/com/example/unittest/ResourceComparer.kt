package com.example.unittest

import android.content.Context

class ResourceComparer {

    fun isEqual(context: Context, resourceId: Int, string: String): Boolean {
        return context.getString(resourceId) == string
    }
}