package com.example.glidefetchdemoforclass

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.glidefetchdemoforclass.Adaptor.ViewHolder

class Adaptor(val context:Context,val userInfo: userInfo):RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.single_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Glide.with(context).load(userInfo.get(position).avatar_url).into(holder.userImage)
        holder.userName.text=userInfo.get(position).login

    }

    override fun getItemCount(): Int {
        return userInfo.size
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val userImage :ImageView =  itemView.findViewById(R.id.imageView)
        val userName :TextView =  itemView.findViewById(R.id.textView)

    }
}