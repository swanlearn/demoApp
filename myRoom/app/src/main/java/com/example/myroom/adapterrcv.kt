package com.example.myroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapterrcv(val  list:List<iteam>):RecyclerView.Adapter<adapterrcv.viewholder>() {
    class viewholder(view:View):RecyclerView.ViewHolder(view){
        lateinit var text:TextView
        init {
            text = view.findViewById(R.id.textc)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder(LayoutInflater.from(parent.context).inflate(R.layout.itam,parent,false))
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.text.text = list[position].name.toString()
    }

    override fun getItemCount() = list.size
}