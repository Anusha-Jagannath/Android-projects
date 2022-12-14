package com.example.chatapplication.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chatapplication.model.UserDetails
import com.example.chatapplication.service.AuthenticationService
import com.example.chatapplication.service.Database

class RegisterViewModel: ViewModel() {

    private val _registerStatus = MutableLiveData<UserDetails>()
    val registerStatus = _registerStatus as LiveData<UserDetails>


    fun setRegisterStatus(userDetails: UserDetails) {
        _registerStatus.value = userDetails
    }


    fun registerUser(name: String, email: String, password: String): Boolean {
        var result = false
        AuthenticationService().register(email, password) { status, message ->
            Log.d("share", "$status")
            if (status) {
                result = true
            } else
                result = false
        }
        return result
    }

    fun addToDatabase(user: UserDetails) {
        var database = Database()
        database.saveUserData(user)
    }
}