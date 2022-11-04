package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class DemoAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 0) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row,parent,false)
            return Row1ViewHolder(view)
        }
        else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row2,parent,false)
            return Row2ViewHolder(view)
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

class Row1ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

}

class Row2ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

}