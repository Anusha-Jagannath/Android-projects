package com.example.coroutineroomapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.coroutineroomapp.R
import com.example.coroutineroomapp.databinding.LoginFragmentBinding

class LoginFragment: Fragment() {

    private lateinit var binding: LoginFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.login_fragment, container, false)
        binding = LoginFragmentBinding.bind(view)
        return view
    }
}