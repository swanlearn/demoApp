package com.example.popupxml30_9

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val but1 = findViewById<AppCompatButton>(R.id.but1)
        val but2 = findViewById<AppCompatButton>(R.id.but2)
        val but3 = findViewById<AppCompatButton>(R.id.but3)
        but1.setOnClickListener {
            val  builder = AlertDialog.Builder(this)
            builder.setTitle("Error")
            //set message for alert dialog
            builder.setMessage("Not Valid")
            builder.setPositiveButton("Yes"){dialogInterface, which ->
                Toast.makeText(applicationContext,"clicked yes",Toast.LENGTH_LONG).show()
            }
            //performing cancel action
            builder.setNeutralButton("Cancel"){dialogInterface , which ->
                Toast.makeText(applicationContext,"clicked cancel\n operation cancel",Toast.LENGTH_LONG).show()
            }
            //performing negative action
            builder.setNegativeButton("No"){dialogInterface, which ->
                Toast.makeText(applicationContext,"clicked No",Toast.LENGTH_LONG).show()
            }
            val alertDialog: AlertDialog = builder.create()
            // Set other dialog properties
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
        but2.setOnClickListener {
           val alerta = CustomAlert()
            alerta.showDialog(this,"as")
        }
        but3.setOnClickListener {
            val dialog = Dialog(this!!,R.style.CustomAlertDialog)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.exel)
            val dialogButton: Button = dialog.findViewById<View>(R.id.save) as Button
            dialogButton.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()
        }
        val but4 = findViewById<AppCompatButton>(R.id.but4)
        but4.setOnClickListener {
            val dialog1 = Dialog(this!!,R.style.CustomAlertDialog2)
            dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog1.setCancelable(false)
            dialog1.setContentView(R.layout.khariaran)
            val dialogButton: AppCompatButton = dialog1.findViewById<View>(R.id.se) as AppCompatButton
            val rv1 = findViewById<RecyclerView>(R.id.rv1)
            var aa = arrayOf<String>("","")
            val co  =  ContactsAdapter(aa)
            val layoutManager = LinearLayoutManager(applicationContext)
            rv1.adapter = co
            rv1.layoutManager = layoutManager
            dialogButton.setOnClickListener {
                dialog1.dismiss()
            }
            dialog1.show()
        }
    }
}
class CustomAlert {

    fun showDialog(activity: Activity?, msg: String?) {
        val dialog = Dialog(activity!!,R.style.CustomAlertDialog)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.alert)
        val dialogButton: Button = dialog.findViewById<View>(R.id.alert1btn) as Button
        dialogButton.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
}