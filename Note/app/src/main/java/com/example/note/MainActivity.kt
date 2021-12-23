package com.example.note

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.widget.AppCompatButton
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
            val dialog = Dialog(this!!,R.style.customdialog)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.adddialog)
            val dialogtext:EditText = dialog.findViewById<View>(R.id.editTextadd) as EditText
            val dialogButton: AppCompatButton = dialog.findViewById<View>(R.id.save) as AppCompatButton
            dialogButton.setOnClickListener {
                    model.Iteam.value!!.add(dialogtext.text.toString())
                    con.notifyDataSetChanged()
                    dialog.dismiss()
            }
            dialog.show()
        }
    }

}
