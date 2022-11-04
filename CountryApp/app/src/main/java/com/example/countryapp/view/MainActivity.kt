package com.example.countryapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countryapp.R
import com.example.countryapp.fragments.CountryFragment
import com.example.countryapp.viewmodel.CountryListAdapter
import com.example.countryapp.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ListViewModel
    private lateinit var adapter: CountryListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(CountryFragment())

//        countriesList.layoutManager = LinearLayoutManager(this)
//        adapter = CountryListAdapter(this,arrayListOf())
//        countriesList.adapter = adapter
//
//        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
//        viewModel.refresh()
//
//        observeViewModel()
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer,fragment)
        fragmentTransaction.commit()
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_item,menu)
//        return super.onCreateOptionsMenu(menu)
//    }

    /**
     * @param 
     */
//    private fun observeViewModel() {
//        viewModel.countries.observe(this, Observer {
//            it?.let {
//                adapter.updateCountry(it)
//            }
//        })
//
//        viewModel.countryLoadError.observe(this, Observer {
//            if(it) {
//                list_error.visibility = View.VISIBLE
//            }
//            else
//                list_error.visibility = View.GONE
//        })
//        viewModel.loading.observe(this, Observer {
//            if(it) {
//                loading_view.visibility = View.VISIBLE
//            }
//            else loading_view.visibility = View.GONE
//        })
//    }
}