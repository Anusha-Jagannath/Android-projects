package com.example.coroutineretrofit.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutineretrofit.model.Country
import com.example.coroutineretrofit.network.CountriesService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CountryViewModel: ViewModel() {

    val countriesService = CountriesService().getCountriesService()
    val countries = MutableLiveData<List<Country>>()
    val countryLoadError = MutableLiveData<String?>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        fetchCountries()
    }

    private fun fetchCountries() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = countriesService.getCountries()
            withContext(Dispatchers.Main) {
                if(response.isSuccessful) {
                    countries.value = response.body()

                }
                else {
                    onError("Error ${response.message()}")
                }
            }
        }
    }


    private fun onError(message: String) {
        countryLoadError.value = message
        loading.value = false
    }

}