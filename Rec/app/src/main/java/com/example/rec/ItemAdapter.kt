package com.example.rec

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 0) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false)
            return NewsViewHolder(view)
        }

        else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.add_item,parent,false)
            return AddViewHolder(view)
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

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {

}

class AddViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

}