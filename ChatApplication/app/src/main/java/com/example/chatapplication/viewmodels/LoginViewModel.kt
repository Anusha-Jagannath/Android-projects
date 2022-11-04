package com.example.chatapplication.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chatapplication.model.UserDetails
import com.example.chatapplication.service.AuthenticationService
import com.example.chatapplication.service.Database

class LoginViewModel : ViewModel() {

    private val _loginStatus = MutableLiveData<UserDetails>()
    val loginStatus = _loginStatus as LiveData<UserDetails>


    fun setLoginStatus(userDetails: UserDetails) {
        _loginStatus.value = userDetails
    }


    fun loginUser(email: String, password: String): Boolean {
        var result = false
        AuthenticationService().login(email, password) { status, message ->
            if (status) {
                result = true
            } else {
                result = false
            }

        }
        return result

    }


    fun readData(): String {
        var database = Database()
        var fullName = database.getData()
        return fullName
    }


}