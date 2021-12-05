package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var button: AppCompatButton
    lateinit var textView2: AppCompatTextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        textView2 = findViewById(R.id.textView2)

        val model = ViewModelProvider(this).get(MyViewModel::class.java)



        button.setOnClickListener(View.OnClickListener {

            model.addCounter()



            model.counterMutableLiveData.observe(this, Observer {


                textView2.text = it.toString()


            })

        })

    }


}