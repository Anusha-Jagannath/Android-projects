package com.example.chatapplication.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.chatapplication.R
import com.example.chatapplication.databinding.ActivityMainBinding
import com.example.chatapplication.viewmodels.SharedViewModel
import com.example.chatapplication.viewmodels.SharedViewModelFactory
import com.google.firebase.auth.FirebaseAuth

open class MainActivity : AppCompatActivity(){

    lateinit var binding: ActivityMainBinding
    private lateinit var sharedViewModel: SharedViewModel
    lateinit var sharedPreference: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreference = getSharedPreferences("USER_INFO", Context.MODE_PRIVATE)
        sharedViewModel = ViewModelProvider(this@MainActivity, SharedViewModelFactory())[SharedViewModel::class.java]
        observeAppNavigation()
        gotoLoginPage()
        Log.i("MainActivity","App status : on create")

    }


    private fun gotoLoginPage() {
        replaceFragment(LoginFragment())
    }

    private fun gotoRegistrationPage() {
        replaceFragment(RegisterFragment())
    }

    private fun gotoProfilePage(profileFragment: ProfileFragment) {
        replaceFragment(profileFragment)
    }

    private fun gotoForgotPage() {
        replaceFragment(ForgotPasswordFragment())
    }

    private fun gotoHomeActivity() {
        var intent = Intent(this@MainActivity,HomeActivityNew::class.java)
        startActivity(intent)
    }

    private fun observeAppNavigation() {
        sharedViewModel.gotoHomePageStatus.observe(this@MainActivity,{
            if(it.loginStatus) {
                Log.d("MainFragment",it.email)
                var bundle = Validation.addInfoToBundle(it)
                var profileFragment = ProfileFragment()
                profileFragment.arguments = bundle
                //gotoProfilePage(profileFragment)
                val editor: SharedPreferences.Editor = sharedPreference.edit()
                editor.putString("NAME",it.userName)
                editor.putString("EMAIL",it.email)
                editor.apply()
                Log.d("MainActivity","saved in shared pref")
                gotoHomeActivity()
            }
        })


        sharedViewModel.gotoRegisterPageStatus.observe(this@MainActivity,{
            if(it) {
                gotoRegistrationPage()
            }
        })

        sharedViewModel.gotoLoginPageStatus.observe(this@MainActivity,{
            if(it) {
                gotoLoginPage()
            }
        })

        sharedViewModel.gotoForgotPageStatus.observe(this@MainActivity,{
            if(it) {
                gotoForgotPage()
            }
        })

    }

    public fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer,fragment)
        fragmentTransaction.commit()
    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity","App status : on start")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity","App status : on start")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity","App status : on pause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity","App status : on stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity","App status : on destroy")
    }

}