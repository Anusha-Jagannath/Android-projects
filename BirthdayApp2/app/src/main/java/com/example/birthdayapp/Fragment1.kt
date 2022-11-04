package com.example.birthdayapp

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.example.birthdayapp.databinding.ActivityMainBinding
import com.example.birthdayapp.databinding.Fragment1Binding

class Fragment1 : Fragment() {
    private lateinit var binding: Fragment1Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment1, container, false)
        binding = Fragment1Binding.bind(view)
        loadMeme()
        return view
    }

    private fun loadMeme() {

        val queue = Volley.newRequestQueue(requireContext())
        val url = "https://meme-api.herokuapp.com/gimme"
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url,null,
            { response ->
                Log.d("sucess",response.toString())
                val newUrl = response.getString("url")
                Glide.with(requireActivity()).load(newUrl).into(binding.memeImage)

            },
            {
               Log.d("Response","response is error")
            })
        queue.add(jsonObjectRequest)

    }

}