package com.example.coroutineretrofit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coroutineretrofit.adapter.CountryAdapter
import com.example.coroutineretrofit.adapter.ICountryRVAdapter
import com.example.coroutineretrofit.databinding.CountryFragmentBinding
import com.example.coroutineretrofit.model.Country
import com.example.coroutineretrofit.viewmodel.CountryViewModel

class CountryFragment : Fragment(), ICountryRVAdapter {

    private lateinit var viewModel: CountryViewModel
    private lateinit var binding: CountryFragmentBinding
    private lateinit var countryList: ArrayList<Country>
    private lateinit var adapter: CountryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.country_fragment, container, false)
        binding = CountryFragmentBinding.bind(view)
        countryList = arrayListOf()
        viewModel = ViewModelProvider(this).get(CountryViewModel::class.java)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = CountryAdapter(countryList, requireContext(), this)
        binding.recyclerView.adapter = adapter
        viewModel.refresh()
        observeData()
        return view
    }

    override fun onItemClicked(country: Country) {
        Toast.makeText(requireContext(), "clicked on $country", Toast.LENGTH_LONG).show()
    }

    private fun observeData() {
        viewModel.countries.observe(viewLifecycleOwner, {
            adapter.update(it)
        })

    }
}