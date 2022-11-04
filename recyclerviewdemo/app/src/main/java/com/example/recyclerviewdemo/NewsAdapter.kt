package com.example.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(private val news: ArrayList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun getItemViewType(position: Int): Int {
        if(news[position].length > 10) {
            return 0
        }
        else return 1
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
        if(viewType == 0) {
            val view = itemView.inflate(R.layout.news_item,parent,false)
            return NewsViewHolder(view)

        }
        else {
            val view = itemView.inflate(R.layout.news_item,parent,false)
            return NewsViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            if(news[position].length>10) {
                val viewHolder = holder as NewsViewHolder
                val currentItem = news[position]
                viewHolder.name.text = currentItem
            }
        else {
            val viewHolder = holder as ImageViewHolder
                val current = news[position]
            }
    }

    override fun getItemCount(): Int {
      return news.size
    }

}

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name = itemView.findViewById<TextView>(R.id.nameTv)
}

class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val img = itemView.findViewById<ImageView>(R.id.jobsImg)
}