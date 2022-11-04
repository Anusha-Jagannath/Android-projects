package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 0) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.happy_item,parent,false)
            return HappyViewHolder(view)
        }
        else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.sad_item,parent,false)
            return SadViewHolder(view)
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

class HappyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

}

class SadViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

}
