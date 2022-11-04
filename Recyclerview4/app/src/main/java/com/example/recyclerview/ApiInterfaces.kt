package com.example.recyclerview

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterfaces {

    @GET("/posts")
    fun getData(): Call<List<User>>
}