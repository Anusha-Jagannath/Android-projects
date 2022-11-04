package com.example.mvvmcountryapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmcountryapp.Country

class ListViewModel : ViewModel(){
  val countries = MutableLiveData<List<Country>>()
    val loadError = MutableLiveData<Boolean>()

}