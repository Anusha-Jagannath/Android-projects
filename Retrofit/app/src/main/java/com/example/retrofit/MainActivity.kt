package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofit.databinding.ActivityMainBinding
import com.example.retrofit.learn.ApiInterface1
import com.example.retrofit.learn.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getMyData()
    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface1::class.java)

        val retrofitData = retrofitBuilder.getData()
        retrofitData.enqueue(object : Callback<List<User>?> {
            override fun onResponse(call: Call<List<User>?>, response: Response<List<User>?>) {
                val retrofitResponse = response.body()
                val stringData = StringBuilder()
                retrofitResponse?.forEach { myData ->
                    stringData.append("${myData.id} \n")
                }
                binding.input.text = stringData
            }

            override fun onFailure(call: Call<List<User>?>, t: Throwable) {
               binding.input.text = "Error while loading the data"
            }
        })
    }
}