package com.example.androidlearn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidlearn.databinding.Fragment1Binding

class Fragment1: Fragment() {
    private lateinit var binding: Fragment1Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment1,container,false)
        binding = Fragment1Binding.bind(view)
        return view
    }
}