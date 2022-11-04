package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SuckAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       if (viewType == 0) {
           val view = LayoutInflater.from(parent.context).inflate(R.layout.platinum_item,parent,false)
           return GoldViewHolder(view)
       }
        else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.gold_item,parent,false)
           return PlatinumViewHolder(view)
       }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       
    }

    override fun getItemCount(): Int {
       return 10
    }

    override fun getItemViewType(position: Int): Int {
        return position % 3
    }
}

class GoldViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

}

class PlatinumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

}