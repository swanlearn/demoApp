package com.example.design27_9vclass

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

lateinit var contacts: ArrayList<Items>
class Home2Activity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home2)
        // Lookup the recyclerview in activity layout

        // Initialize contacts
        contacts = arrayListOf<Items>( Items("","","",""))
       // contacts = Contact.createContactsList("","","","")
        // Create adapter passing in the sample user data
        add()

        // That's all!
    }
    fun add() {
        val rvContacts = findViewById<View>(R.id.rcviwe) as RecyclerView
        val adapter = ContactsAdapter(contacts)
        // Attach the adapter to the recyclerview to populate items
        rvContacts.adapter = adapter
        // Set layout manager to position the items
        rvContacts.layoutManager = LinearLayoutManager(this)
    }

}
