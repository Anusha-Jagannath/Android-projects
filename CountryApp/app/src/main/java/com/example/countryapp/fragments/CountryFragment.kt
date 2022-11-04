package com.example.countryapp.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ProgressBar

import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.countryapp.Constants
import com.example.countryapp.R
import com.example.countryapp.model.Country
import com.example.countryapp.viewmodel.CountryItemClicked
import com.example.countryapp.viewmodel.CountryListAdapter
import com.example.countryapp.viewmodel.ListViewModel
import java.util.*
import kotlin.collections.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CountryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CountryFragment : Fragment(), CountryItemClicked {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var viewModel: ListViewModel
    private lateinit var adapter: CountryListAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var listError: AppCompatTextView
    private lateinit var loader: ProgressBar
    private lateinit var newCountry: Country
    private lateinit var tempList: ArrayList<Country>
    private lateinit var countryList: ArrayList<Country>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_country, container, false)
        listError = view.findViewById(R.id.list_error)
        loader = view.findViewById(R.id.loading_view)
        recyclerView = view.findViewById(R.id.countriesList)
        tempList = arrayListOf()
        countryList = arrayListOf()

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = CountryListAdapter(requireContext(), arrayListOf(), this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.refresh()

        observeViewModel()
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_item, menu)
        val item = menu.findItem(R.id.search_action)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }

        })

    }


    private fun observeViewModel() {
        viewModel.countries.observe(viewLifecycleOwner, {
            tempList.addAll(it)
            countryList.addAll(it)
            it?.let {
                adapter.updateCountry(tempList)
            }
        })

        viewModel.countryLoadError.observe(viewLifecycleOwner, {
            if (it) {
                listError.visibility = View.VISIBLE
            } else
                listError.visibility = View.GONE
        })
        viewModel.loading.observe(viewLifecycleOwner, {
            if (it) {
                loader.visibility = View.VISIBLE
            } else loader.visibility = View.GONE
        })
        viewModel.gotoCountryInfoFragment.observe(viewLifecycleOwner, {
            replaceFragment(CountryInfoFragment())
        })
    }

    override fun onItemClick(country: Country) {
        Toast.makeText(requireContext(), "item clicked", Toast.LENGTH_SHORT).show()
        newCountry = country
        viewModel.gotoCountryInfoFragment.value = true
    }

    private fun replaceFragment(fragment: Fragment) {
        val bundle = Bundle()
        bundle.putString(Constants.FLAG, newCountry.flag)
        bundle.putString(Constants.COUNTRY_NAME, newCountry.countryName)
        bundle.putString(Constants.COUNTRY_CAPITAL, newCountry.capital)
        fragment.arguments = bundle

        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment).commit()
    }
}