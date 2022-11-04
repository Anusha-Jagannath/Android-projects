package com.example.countryapp.model

import com.example.countryapp.di.DaggerApiComponent
import io.reactivex.Single
import javax.inject.Inject


class CountriesService {

    @Inject
    lateinit var api: CountriesApi

    init {
        DaggerApiComponent.create().inject(this)
    }

    fun getCountries(): Single<List<Country>> {
        return api.getCountries()
    }
}