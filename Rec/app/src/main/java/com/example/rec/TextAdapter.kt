package com.example.rec

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TextAdapter(private val itemList: ArrayList<String>, private val listener: Listener) :
    RecyclerView.Adapter<TextViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_item, parent, false)
        val holder = TextViewHolder(view)
        view.setOnClickListener {
            listener.onClick(itemList[holder.adapterPosition])
        }
        return holder
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}

class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(currentItem: String) {
        val textTv = itemView.findViewById<TextView>(R.id.textTv)
        textTv.text = currentItem
    }
}

interface Listener {
    fun onClick(item: String)
}