package com.example.unittest

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ResourceComparerTest {

    private lateinit var resourceComparer: ResourceComparer

    @Before
    fun setUp() {
        resourceComparer = ResourceComparer()
    }

    @Test
    fun stringResourceSameAsGivenString_thenReturnTrue() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val actualResult = resourceComparer.isEqual(context, R.string.app_name,"UnitTest")
        Assert.assertTrue(actualResult)
    }

    @Test
    fun stringResourceNotSameAsString_thenReturnFalse() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val actualResult = resourceComparer.isEqual(context, R.string.app_name,"unittest")
        Assert.assertFalse(actualResult)
    }
}