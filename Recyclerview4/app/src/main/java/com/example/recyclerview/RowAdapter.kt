package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RowAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 0) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.row_item1, parent, false)
            return RowViewHolder1(view)
        } else {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.row_item2, parent, false)
            return RowViewHolder2(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun getItemViewType(position: Int): Int {
        if (position % 3 == 0) {
            return 0
        }
        return 1
    }
}

class RowViewHolder1(itemView: View) : RecyclerView.ViewHolder(itemView) {

}

class RowViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {

}