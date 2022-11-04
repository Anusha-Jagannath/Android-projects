package com.example.countryapp.viewmodel

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.countryapp.model.Country
import com.example.countryapp.R
import java.util.*
import kotlin.collections.ArrayList

class CountryListAdapter(
    private val context: Context,
    private var countryList: ArrayList<Country>,
    private val listener: CountryItemClicked
) :
    RecyclerView.Adapter<CountryViewHolder>(), Filterable {
    var filteredList: ArrayList<Country> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.country_item, parent, false)
        val viewHolder = CountryViewHolder(view)
        view.setOnClickListener {
            listener.onItemClick(countryList[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val currentCountry = countryList[position]
        holder.countryName.text = currentCountry.countryName
        holder.countryCapital.text = currentCountry.capital
        Glide.with(context).load(currentCountry.flag).into(holder.countryImage)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    fun updateCountry(newCountryList: List<Country>) {
        countryList.clear()
        countryList.addAll(newCountryList)
        filteredList.addAll(newCountryList)
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object: Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                var newList: ArrayList<Country> = arrayListOf()
                filteredList.clear()
                val searchText = constraint.toString().toLowerCase(Locale.getDefault())
                if (searchText.isNotEmpty()) {
                    countryList.forEach {
                        if (it.countryName?.toLowerCase(Locale.getDefault())
                                ?.contains(searchText) == true
                        ) {
                            filteredList.add(it)
                        }
                    }
                    Log.d("Filtered list", filteredList.toString())
                    newList.addAll(filteredList)

                } else {
                    Log.d("Country List",countryList.toString())
                    newList.addAll(countryList)
                }

                val filterResults = FilterResults()
                filterResults.values = newList
                return filterResults
            }

            override fun publishResults(p0: CharSequence?, result: FilterResults?) {
                countryList = result?.values as ArrayList<Country>
                notifyDataSetChanged()
            }

        }
    }

}

class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val countryImage: ImageView = itemView.findViewById(R.id.imageView)
    val countryName: TextView = itemView.findViewById(R.id.name)
    val countryCapital: TextView = itemView.findViewById(R.id.capital)
}

interface CountryItemClicked {
    fun onItemClick(country: Country)
}