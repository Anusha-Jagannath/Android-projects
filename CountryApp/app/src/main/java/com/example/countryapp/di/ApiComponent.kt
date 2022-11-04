package com.example.countryapp.di

import com.example.countryapp.model.CountriesService
import com.example.countryapp.viewmodel.ListViewModel
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {

    fun inject(service: CountriesService)

    fun inject(viewModel: ListViewModel)
}