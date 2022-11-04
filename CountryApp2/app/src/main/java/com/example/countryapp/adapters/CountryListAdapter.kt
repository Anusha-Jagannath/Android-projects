package com.example.countryapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.countryapp.Country
import com.example.countryapp.R

class CountryListAdapter(
    private val countryList: ArrayList<Country>,
    private val context: Context,
    private val listener: CountryItemClicked
) : RecyclerView.Adapter<CountryListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryListViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_country, parent, false)
        val viewHolder = CountryListViewHolder(view)
        view.setOnClickListener {
            listener.onItemClick(countryList[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: CountryListViewHolder, position: Int) {
        val currentItem = countryList[position]
        holder.name.text = currentItem.countryName
        holder.capital.text = currentItem.countryCapital
        Glide.with(context).load(currentItem.flag)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    fun updateCountry(newCountryList: List<Country>) {
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }
}

class CountryListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val name: TextView = itemView.findViewById(R.id.name)
    val capital: TextView = itemView.findViewById(R.id.capital)
    val img: ImageView = itemView.findViewById(R.id.imageView)
}

interface CountryItemClicked {
    fun onItemClick(country: Country)
}
