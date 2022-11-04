package com.example.coroutineroomapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.coroutineroomapp.R
import com.example.coroutineroomapp.databinding.SignupFragmentBinding

class SignupFragment : Fragment() {
    private lateinit var binding: SignupFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.signup_fragment, container, false)
        binding = SignupFragmentBinding.bind(view)
        return view
    }
}