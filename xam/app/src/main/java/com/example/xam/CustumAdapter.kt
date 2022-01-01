package com.example.xam


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustumAdapter(val datal:ArrayList<datas>):RecyclerView.Adapter<CustumAdapter.viewHolder>() {
    class viewHolder(view: View): RecyclerView.ViewHolder(view) {
        val text1:TextView
        val text2:TextView
        val text3:TextView
        val text4:TextView

        init {
            text1 = view.findViewById(R.id.ter1)
            text2 = view.findViewById(R.id.ter2)
            text3 = view.findViewById(R.id.ter3)
            text4 = view.findViewById(R.id.ter4)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rc_item,parent,false)
        return viewHolder(view)
    }
    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.text1.text =datal[position].date.toString()
    }
    override fun getItemCount()= datal.size
}



data class datas(var name:String,val date:String,val time:String,val user:String)