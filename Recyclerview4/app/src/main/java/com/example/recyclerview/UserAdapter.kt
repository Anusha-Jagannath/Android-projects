package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val userList: ArrayList<User>): RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
       holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val title = itemView.findViewById<AppCompatTextView>(R.id.newTitle)
    private val subtitle = itemView.findViewById<AppCompatTextView>(R.id.subtitle)
    fun bind(user: User) {
        title.text = user.userId.toString()
        subtitle.text = user.id.toString()
    }

}