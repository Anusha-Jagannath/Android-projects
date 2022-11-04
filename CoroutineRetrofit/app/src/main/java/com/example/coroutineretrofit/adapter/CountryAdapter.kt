package com.example.coroutineretrofit.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coroutineretrofit.R
import com.example.coroutineretrofit.model.Country

class CountryAdapter(private val countryList: ArrayList<Country>, private val context: Context, private val listener: ICountryRVAdapter) :
    RecyclerView.Adapter<CountryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.country_item, parent, false)
        val viewHolder = CountryViewHolder(view)

        viewHolder.itemView.setOnClickListener {
            listener.onItemClicked(countryList[viewHolder.adapterPosition])
        }
        return  viewHolder
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        val currentList = countryList[position]
        holder.name.text = currentList.countryName
        holder.capital.text = currentList.capital
        Glide.with(context).load(currentList.flag).into(holder.img)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    fun update(newList: List<Country>) {
        countryList.clear()
        countryList.addAll(newList)
        notifyDataSetChanged()
    }
}

class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val img = itemView.findViewById<ImageView>(R.id.imgView)
    val name = itemView.findViewById<TextView>(R.id.nameTv)
    val capital = itemView.findViewById<TextView>(R.id.capitalTv)
}

interface ICountryRVAdapter {
    fun onItemClicked(country: Country)
}