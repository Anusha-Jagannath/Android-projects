package com.example.countryapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countryapp.Country
import com.example.countryapp.network.CountriesService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ListViewModel : ViewModel() {
    private val countriesService = CountriesService()
    private val disposable = CompositeDisposable()

    private val _countries = MutableLiveData<List<Country>>()
    var countries = _countries as LiveData<List<Country>>

    private val _countryLoadError = MutableLiveData<Boolean>()
    var countryLoadError = _countryLoadError as LiveData<Boolean>

    private val _loading = MutableLiveData<Boolean>()
    var loading = _loading as LiveData<Boolean>

    fun setCountries(countries: List<Country>) {
        _countries.value = countries
    }

    fun setCountryLoadError(status: Boolean) {
        _countryLoadError.value = status
    }

    fun setLoading(status: Boolean) {
        _loading.value = status
    }

    fun refresh() {
        fetchCountries()
    }

    private fun fetchCountries() {
        setLoading(true)
        disposable.add(
            countriesService.getCountries()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<List<Country>>() {
                    override fun onSuccess(value: List<Country>?) {
                        if (value != null) {
                            setCountries(value)
                        }
                        setCountryLoadError(false)
                        setLoading(false)
                    }

                    override fun onError(e: Throwable?) {
                        setCountryLoadError(true)
                        setLoading(false)
                    }

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}