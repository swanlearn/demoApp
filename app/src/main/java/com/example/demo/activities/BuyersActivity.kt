package com.example.demo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.PopupWindow
import androidx.appcompat.app.AlertDialog
import com.example.demo.R
import com.example.demo.databinding.ActivityBuyersBinding


class BuyersActivity : AppCompatActivity() {

    lateinit var binding:ActivityBuyersBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityBuyersBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        /**
         * click On خزیداران
         */
        binding.relCustomers.setOnClickListener(View.OnClickListener {


          val view=View.inflate(this,R.layout.popup_buyers,null)


            val builder = AlertDialog.Builder(this)
            builder.setView(view)

            val dialog = builder.create()
            dialog.show()





        })
    }
}