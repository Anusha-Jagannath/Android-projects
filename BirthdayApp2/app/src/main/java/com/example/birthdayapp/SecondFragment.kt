package com.example.birthdayapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.birthdayapp.databinding.SecondFragmentBinding

class SecondFragment: Fragment() {
    private lateinit var binding: SecondFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.second_fragment,container,false)
        binding = SecondFragmentBinding.bind(view)
        val args = this.arguments
        val name = args?.get("data")
        binding.birthdayGreeting.text = "Happy birthday $name"
        return view
    }
}