package com.example.demo

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
<<<<<<< HEAD
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.incrementExact
import kotlin.properties.ReadOnlyProperty
=======
import android.util.Log
import androidx.activity.viewModels
import com.example.demo.databinding.ActivityMainBinding
>>>>>>> master

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val model : MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
<<<<<<< HEAD
        setContentView(R.layout.activity_main)
        val model:MyviewModel by viewModels()

        button.setOnClickListener {
            model.increment()
        }

        val observer = Observer<Int> {
            textView.text = it.toString()
        }


        model.counter.observe(this,observer)

=======
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        model.counter.observe(this, {
            binding.textView.text = it.toString()
            Log.d("TAG", "onCreate: clicked")
        })

        binding.button.setOnClickListener {
            model.increment()
        }

>>>>>>> master
    }





}