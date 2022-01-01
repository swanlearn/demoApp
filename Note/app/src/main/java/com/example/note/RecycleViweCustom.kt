package com.example.note

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView

class RecycleViweCustom(var Index1: ArrayList<String>?)
    :RecyclerView.Adapter<RecycleViweCustom.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val  delet: AppCompatButton

        init {
            // Define click listener for the ViewHolder's View.
            delet = view.findViewById(R.id.delet)
            textView = view.findViewById(R.id.editText1)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.coustum_iteam_review, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
            viewHolder.textView.setText(Index1!![position].toString())
            viewHolder.textView.addTextChangedListener {
                Index1!![position] = it.toString()
            }
        viewHolder.delet.setOnClickListener {
            Index1!!.remove(viewHolder.textView.text.toString())
            notifyDataSetChanged()
        }
    }

    override fun getItemCount() = Index1!!.size

}
