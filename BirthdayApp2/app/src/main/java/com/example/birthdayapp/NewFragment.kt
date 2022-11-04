package com.example.birthdayapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.birthdayapp.databinding.NewFragmentBinding

class NewFragment: Fragment() {
    private lateinit var binding: NewFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.new_fragment,container,false)
        binding = NewFragmentBinding.bind(view)
        return view
    }
}