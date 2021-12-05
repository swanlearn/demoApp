package com.example.demo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.demo.R
import com.example.demo.viewModels.CounterViewModel

class CounterActivity : AppCompatActivity() {


    lateinit var button: AppCompatButton
    lateinit var textView2: AppCompatTextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        button = findViewById(R.id.button)
        textView2 = findViewById(R.id.textView2)

        val model = ViewModelProvider(this).get(CounterViewModel::class.java)

        button.setOnClickListener(View.OnClickListener {

            model.addCounter()

            model.counterMutableLiveData.observe(this, Observer {


                textView2.text = it.toString()


            })

        })

    }
}