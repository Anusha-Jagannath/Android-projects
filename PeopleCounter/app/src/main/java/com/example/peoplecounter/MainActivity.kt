package com.example.peoplecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.peoplecounter.fragments.LoginFragment
import com.example.peoplecounter.fragments.RegisterFragment
import com.example.peoplecounter.presenters.MainActivityPresenter
import com.example.peoplecounter.presenters.MainActivityPresenterImpl
import com.example.peoplecounter.view.MainActivityView

class MainActivity : AppCompatActivity(),MainActivityView {

    //private lateinit var presenterImpl: MainActivityPresenterImpl
    private var presenter: MainActivityPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainActivityPresenterImpl(this)
        presenter.let {
            if (it != null) {
                lifecycle.addObserver(it)
            }
        }
        gotoLoginPage()

    }

    private fun gotoLoginPage() {
        replaceFragment(LoginFragment())
    }

    private fun replaceFragment(fragment:Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer,fragment)
        fragmentTransaction.commit()
    }

    override fun launchRegisterScreen() {
       Log.d("REPLACE","fragment")
        replaceFragment(RegisterFragment())
    }
}