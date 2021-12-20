package com.example.design27_9vclass

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import android.R




class ContactsAdapter(private val mContacts: List<Contact>) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    open fun getItemViewType(position: Int): Int {
        return if (position == myItems.size()) R.layout.button else R.layout.
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        val edittext1 = itemView.findViewById<EditText>(R.id.textrw1)
        val edittext2 = itemView.findViewById<EditText>(R.id.textrw2)
        val edittext3 = itemView.findViewById<EditText>(R.id.textrw3)
        val edittext4 = itemView.findViewById<EditText>(R.id.textrw4)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.costum_recicle_viwe, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(viewHolder: ContactsAdapter.ViewHolder, position: Int) {
        // Get the data model based on position
        val contact: Contact = mContacts.get(position)
        // Set item views based on your views and data model
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return mContacts.size
    }
}
class Contact(val text: String,val text2: String,val text3: String,val text4: String) {
    companion object {
        private var lastContactId = 0
        fun createContactsList(etext: String,etext2: String,etext3: String,etext4: String): ArrayList<Contact> {
            val contacts = ArrayList<Contact>()
                contacts.add(Contact("","","",""))

            return contacts
        }
    }
}

