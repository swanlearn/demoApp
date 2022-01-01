package com.example.design27_9vclass

import android.content.res.Resources
import android.inputmethodservice.ExtractEditText
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.text.set
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ContactsAdapter(private var mContacts: ArrayList<Items>) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {
    public fun getItemviewType(position: Int):Int{
        if(position == mContacts.size-1&&position !=0) return R.layout.butrew else  return R.layout.costum_recicle_viwe
    }
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        var edittext1 = view.findViewById<AppCompatEditText>(R.id.textrw1)
        var edittext2 = view.findViewById<AppCompatEditText>(R.id.textrw2)
        var edittext3 = view.findViewById<EditText>(R.id.textrw3)
        var edittext4 = view.findViewById<EditText>(R.id.textrw4)
        val addbut = itemView.findViewById<AppCompatButton>(R.id.but_add)
    }
    override fun onCreateViewHolder(viewCroup: ViewGroup, viewType: Int): ContactsAdapter.ViewHolder {
        val view = LayoutInflater.from(viewCroup.context)
            .inflate(R.layout.costum_recicle_viwe,viewCroup,false)
        // Inflate the custom layout
        return ViewHolder(view)
    }
    // Involves populating data into the item through holder
    override fun onBindViewHolder(viewHolder: ContactsAdapter.ViewHolder, position: Int) {
        // Get the data model based on position

        viewHolder.addbut.visibility = View.INVISIBLE
        if(position == mContacts.size-1)  viewHolder.addbut.visibility = View.VISIBLE
        viewHolder.addbut.setOnClickListener {
            contacts.add(Items("","","",""))
            this.mContacts= contacts
            this.notifyDataSetChanged()
        }
        // Set item views based on your views and data model
    }
    // Returns the total count of items in the list
    override fun getItemCount() = mContacts.size
    fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

}

data class Items (val text:String, val text2:String, val text3:String, val text4:String)
