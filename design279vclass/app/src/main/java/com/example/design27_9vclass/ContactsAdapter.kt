package com.example.design27_9vclass

import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import androidx.core.text.set
import androidx.recyclerview.widget.RecyclerView

class ContactsAdapter(private val mContacts: Array<Contact>) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {
    public fun getItemviewType(position: Int):Int{
        if(position == mContacts.size) return R.layout.butrew else  return R.layout.costum_recicle_viwe
    }
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        val edittext1 = view.findViewById<EditText>(R.id.textrw1)
        val edittext2 = view.findViewById<EditText>(R.id.textrw2)
        val edittext3 = view.findViewById<EditText>(R.id.textrw3)
        val edittext4 = view.findViewById<EditText>(R.id.textrw4)
       // val addbut = itemView.findViewById<AppCompatButton>(R.id.but_add)
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
        viewHolder.edittext1.text = mContacts[position].text.toEditable()
       // text2.setText(contact.text2)
       // text3.setText(contact.text3)
       // text4.setText(contact.text4)
        // Set item views based on your views and data model
    }
    // Returns the total count of items in the list
    override fun getItemCount() = mContacts.size
    fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

}

class Contact(val text: String,val text2: String,val text3: String,val text4: String) {
    companion object {
        private var lastContactId = 0
        fun createContactsList(etext: String,etext2: String,etext3: String,etext4: String): ArrayList<Contact> {
            val contacts = ArrayList<Contact>()
                contacts.add(Contact(etext,etext2,etext3,etext4))
            return contacts
        }
    }
}

