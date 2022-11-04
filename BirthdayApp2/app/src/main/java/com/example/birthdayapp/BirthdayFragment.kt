package com.example.birthdayapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.birthdayapp.databinding.BirthdayFragmentBinding

class BirthdayFragment: Fragment() {
    private lateinit var binding: BirthdayFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view = inflater.inflate(R.layout.birthday_fragment,container,false)
        binding = BirthdayFragmentBinding.bind(view)
        binding.submitBtn.setOnClickListener {
            val name = binding.nameInput.text.toString()
            if(name.isNotEmpty()) {
                val bundle = Bundle()
                bundle.putString("data",name)
                val fragment = SecondFragment()
                fragment.arguments = bundle
                requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fContainer,fragment).commit()
            }
            else {
                Toast.makeText(requireContext(),"Please enter name",Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
}