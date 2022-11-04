package com.example.chatapplication.service

import android.util.Log
import com.example.chatapplication.model.UserDetails
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.util.*
import kotlin.collections.ArrayList

class Database {

    fun saveUserData(user: UserDetails) {
        FirebaseDatabase.getInstance().getReference("Users")
            .child(FirebaseAuth.getInstance().currentUser!!.uid)
            .setValue(user).addOnCompleteListener {
                if (it.isSuccessful) {
                    Log.d("Database", "successfully added")
                }
            }
    }


    fun getData(): String {
        var fullName = ""
        FirebaseDatabase.getInstance().getReference("Users")
            .child(FirebaseAuth.getInstance().currentUser!!.uid)
            .get().addOnSuccessListener {

                if (it.exists()) {
                    fullName = it.child("userName").value.toString()
                }
            }
        return fullName
    }
}


