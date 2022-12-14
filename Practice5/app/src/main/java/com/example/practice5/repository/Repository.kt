package com.example.practice5.repository

import androidx.lifecycle.LiveData
import com.example.practice5.models.User
import com.example.practice5.network.RetrofitBuilder
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

object Repository {

    var job: CompletableJob? = null

    fun getUser(userId: String): LiveData<User> {
        job = Job()
        return object: LiveData<User>(){
            override fun onActive() {
                super.onActive()
                job?.let{ theJob ->
                    CoroutineScope(IO + theJob).launch {
                        val user = RetrofitBuilder.apiService.getUser(userId)
                        withContext(Main){
                            value = user
                            theJob.complete()
                        }
                    }

                }

            }
        }
    }

    fun cancelJobs(){
        job?.cancel()
    }

}