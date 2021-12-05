package com.example.demo

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.incrementExact
import kotlin.properties.ReadOnlyProperty

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val model:MyviewModel by viewModels()

        button.setOnClickListener {
            model.increment()
        }

        val observer = Observer<Int> {
            textView.text = it.toString()
        }


        model.counter.observe(this, observer)

    }

}