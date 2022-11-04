package com.example.retrofit.learn

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface1 {

    @GET("posts")
    fun getData(): Call<List<User>>
}