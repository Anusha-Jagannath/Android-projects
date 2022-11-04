package com.example.chatapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import com.example.chatapplication.R
import com.example.chatapplication.model.UserDetails
import com.example.chatapplication.viewmodels.RegisterViewModel
import com.example.chatapplication.viewmodels.RegisterViewModelFactory
import com.example.chatapplication.viewmodels.SharedViewModel
import com.example.chatapplication.viewmodels.SharedViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterFragment : Fragment(R.layout.fragment_register) {

    lateinit var loginText: TextView
    lateinit var userName: EditText
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var confirmPassword: EditText
    lateinit var register: Button
    lateinit var loading: ProgressBar
    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_register, container, false)
        loginText = view.findViewById<TextView>(R.id.alreadyHaveAccount)
        userName = view.findViewById(R.id.inputUserName)
        email = view.findViewById(R.id.inputEmail)
        password = view.findViewById(R.id.userPassword)
        confirmPassword = view.findViewById(R.id.confirmPassword)

        loading = view.findViewById(R.id.progressIcon)

        sharedViewModel = ViewModelProvider(
            requireActivity(),
            SharedViewModelFactory()
        )[SharedViewModel::class.java]
        registerViewModel =
            ViewModelProvider(this, RegisterViewModelFactory())[RegisterViewModel::class.java]

        register = view.findViewById(R.id.buttonRegister)
        registerObservers()
        register.setOnClickListener {

            if (Validation.checkCredentialsForRegister(
                    userName,
                    email,
                    password,
                    confirmPassword,requireContext()
                )
            ) {
                loading.visibility = View.VISIBLE
                var emailId = email.editableText.toString()
                var pass = password.editableText.toString()
                var name = userName.editableText.toString()

                var status = registerViewModel.registerUser(name, emailId, pass)
                Toast.makeText(context, "Status : $status", Toast.LENGTH_SHORT).show()
                if (!status) {
                    var newUser = UserDetails(name, emailId, true)
                    registerViewModel.addToDatabase(newUser)
                    //var database = Database()
                    //database.saveUserData(newUser)
                    registerViewModel.setRegisterStatus(newUser)
                    Toast.makeText(context, "regsiter success", Toast.LENGTH_SHORT).show()
                    sharedViewModel.setGotoHomePageStatus(newUser)
                } else {
                    Toast.makeText(context, "register unsucess", Toast.LENGTH_SHORT).show()
                }

            }

        }

        loginText.setOnClickListener {
            Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            sharedViewModel.setGotoLoginPageStatus(true)


        }


        return view
    }


    private fun registerObservers() {
        registerViewModel.registerStatus.observe(viewLifecycleOwner) {
            if (it.loginStatus) {
                Toast.makeText(requireContext(), "User registerd", Toast.LENGTH_SHORT).show()
                sharedViewModel.setGotoHomePageStatus(it)
            } else {
                Toast.makeText(requireContext(), "register failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

}