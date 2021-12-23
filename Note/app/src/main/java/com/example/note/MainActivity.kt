package com.example.note

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.compose.ui.window.Dialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val add = findViewById<AppCompatButton>(R.id.addbtn)
        val actionbar_main = supportActionBar
        actionbar_main!!.hide()
        val model : ViewModels by viewModels()
        val rec = findViewById<RecyclerView>(R.id.Recycleviwe1)
        val con = RecycleViweCustom(model.Iteam.value)
        rec.adapter = con
        rec.layoutManager = LinearLayoutManager(this)
        add.setOnClickListener {
            val dialog =  Dialog()

            val view = layoutInflater.inflate(R.layout.adddialog,null)
            val text = findViewById<EditText>(R.id.editTextadd)
            dialog.setView(view)
            val save = findViewById<AppCompatButton>(R.id.save)
            save.setOnClickListener {
                i
            }
            dialog.show()
        }
    }
}