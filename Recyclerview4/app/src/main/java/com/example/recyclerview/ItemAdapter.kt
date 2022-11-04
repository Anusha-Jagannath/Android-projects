package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ItemAdapter(): RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       if (viewType == 0){
           val view = LayoutInflater.from(parent.context).inflate(R.layout.item1, parent, false)
           return Item1ViewHolder(view)
       } else {
           val view = LayoutInflater.from(parent.context).inflate(R.layout.item2, parent, false)
           return Item2ViewHolder(view)
       }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 3 == 0) {
            0
        } else 1
    }
}

class Item1ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

}

class Item2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

}