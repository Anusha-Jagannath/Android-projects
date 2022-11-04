package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView

class TextAdapter(private val text: ArrayList<String>, private val listener: IClick): RecyclerView.Adapter<TextViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_text,parent,false)
        return TextViewHolder(view)
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.bind(text[position],listener)
    }

    override fun getItemCount(): Int {
       return text.size
    }
}

class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val text = itemView.findViewById<AppCompatTextView>(R.id.title)
    fun bind(data: String, listener: IClick) {
        text.text = data
        text.setOnClickListener {
            listener.onClick(data)
        }
    }
}

interface IClick {
    fun onClick(data: String)
}