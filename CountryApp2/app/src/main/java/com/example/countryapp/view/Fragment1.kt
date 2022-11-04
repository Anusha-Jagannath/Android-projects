package com.example.countryapp.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countryapp.Country
import com.example.countryapp.R
import com.example.countryapp.adapters.CountryItemClicked
import com.example.countryapp.adapters.CountryListAdapter
import com.example.countryapp.databinding.Fragment1Binding
import com.example.countryapp.viewmodel.ListViewModel

class Fragment1: Fragment(), CountryItemClicked {
    private lateinit var binding: Fragment1Binding
    private lateinit var viewModel: ListViewModel
    private lateinit var adapter: CountryListAdapter
    private val countries = arrayListOf<Country>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment1,container,false)
        binding = Fragment1Binding.bind(view)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        binding.countriesList.layoutManager = LinearLayoutManager(requireContext())
        adapter = CountryListAdapter(countries,requireContext(),this)
        binding.countriesList.adapter = adapter

        observeViewModel()
        return  view
    }

    private fun observeViewModel() {
        viewModel.countries.observe(viewLifecycleOwner,{
            it?.let {
                adapter.updateCountry(it)
            }
        })
        viewModel.countryLoadError.observe(viewLifecycleOwner,{
            if(it) {
                binding.errorTv.visibility = View.VISIBLE
            }
            else {
                binding.errorTv.visibility = View.GONE
            }
        })

        viewModel.loading.observe(viewLifecycleOwner, {
            if(it) {
                binding.loader.visibility = View.VISIBLE
            }
            else {
                binding.loader.visibility = View.GONE
            }
        })
    }

    override fun onItemClick(country: Country) {
        Log.d("clicked on ","$country")
    }

}