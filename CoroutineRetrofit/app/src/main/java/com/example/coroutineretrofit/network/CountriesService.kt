package com.example.coroutineretrofit.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CountriesService {

    private val baseUrl = "https://raw.githubusercontent.com"

    fun getCountriesService(): CountriesApi {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CountriesApi::class.java)
    }
}