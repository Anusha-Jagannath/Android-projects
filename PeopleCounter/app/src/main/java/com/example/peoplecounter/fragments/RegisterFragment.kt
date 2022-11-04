package com.example.peoplecounter.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.VisibleForTesting
import com.example.peoplecounter.R

class RegisterFragment : Fragment() {
    private lateinit var accountText: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_register, container, false)
        accountText = view.findViewById(R.id.alreadyHaveAccount)
     //   accountText.setOnClickListener { presenter.onAccountTextClicked() }
        return view
    }

    private fun replaceFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, LoginFragment()).commit()
    }
    
}