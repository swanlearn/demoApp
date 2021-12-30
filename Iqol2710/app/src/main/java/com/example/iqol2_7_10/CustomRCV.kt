package com.example.iqol2_7_10

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView

class CustomRCV(val Datal:ArrayList<data>):RecyclerView.Adapter<CustomRCV.ViewHolder>(){
    class ViewHolder(IteamView:View):RecyclerView.ViewHolder(IteamView){
        val text1: TextView
        val text2: TextView
        val text3: TextView

        init {
            // Define click listener for the ViewHolder's View.
            text1 = IteamView.findViewById(R.id.textr1)
            text2 = IteamView.findViewById(R.id.textr2)
            text3 = IteamView.findViewById(R.id.textr3)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text1.setText( Datal[position].name.toString())
        holder.text2.setText( Datal[position].email.toString())
        holder.text3.setText( Datal[position].Phone.toString())
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_recycleview,parent,false)
        return ViewHolder(view)
    }
    override fun getItemCount()= Datal.size
}
data class data(var name:String,var email:String,var Phone:String )