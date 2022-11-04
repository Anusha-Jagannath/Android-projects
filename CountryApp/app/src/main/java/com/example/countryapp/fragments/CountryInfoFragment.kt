package com.example.countryapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.countryapp.Constants
import com.example.countryapp.R
import com.example.countryapp.viewmodel.ListViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CountryInfoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CountryInfoFragment : Fragment() {
    private lateinit var countryFlag: ImageView
    private lateinit var countryText: AppCompatTextView
    private lateinit var countryCapital: AppCompatTextView
    private lateinit var backButton: ImageView

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_country_info, container, false)
        countryFlag = view.findViewById(R.id.flag)
        countryText = view.findViewById(R.id.country)
        countryCapital = view.findViewById(R.id.capital)
        backButton = view.findViewById(R.id.back)
        setData()
        attachListener()
        return view

    }

    private fun setData() {
        val args = this.arguments
        val url = args?.get(Constants.FLAG)
        val name = args?.get(Constants.COUNTRY_NAME)
        val capital = args?.get(Constants.COUNTRY_CAPITAL)
        countryText.text = name.toString()
        countryCapital.text = capital.toString()
        Glide.with(requireActivity()).load(url).into(countryFlag)
    }

    private fun attachListener() {
        backButton.setOnClickListener { gotoCountryFragment() }
    }

    private fun gotoCountryFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, CountryFragment()).commit()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CountryInfoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CountryInfoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}