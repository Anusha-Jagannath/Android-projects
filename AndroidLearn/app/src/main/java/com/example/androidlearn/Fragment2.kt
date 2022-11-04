package com.example.androidlearn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidlearn.databinding.Fragment2Binding

class Fragment2: Fragment() {
    private lateinit var binding: Fragment2Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment2,container,false)
        binding = Fragment2Binding.bind(view)
        return view
    }
}