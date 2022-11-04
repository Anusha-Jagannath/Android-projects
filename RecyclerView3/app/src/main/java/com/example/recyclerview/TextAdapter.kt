package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TextAdapter(private val item: ArrayList<String>): RecyclerView.Adapter<TextViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_text,parent,false)
        return TextViewHolder(view)
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
      holder.bind(item[position])
    }

    override fun getItemCount(): Int {
       return item.size
    }
}

class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: String) {
        val textTv = itemView.findViewById<TextView>(R.id.textTv)
        textTv.text = item
    }
}