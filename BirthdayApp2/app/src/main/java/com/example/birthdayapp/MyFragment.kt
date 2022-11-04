package com.example.birthdayapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.birthdayapp.databinding.MyFragmentBinding

class MyFragment: Fragment() {
    private lateinit var binding: MyFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.my_fragment,container,false)
        binding = MyFragmentBinding.bind(view)
        return view
    }
}