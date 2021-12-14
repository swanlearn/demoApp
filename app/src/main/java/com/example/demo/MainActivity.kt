package com.example.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.demo.activities.BuyersActivity
import com.example.demo.activities.CounterActivity
import com.example.demo.activities.RegisterActivity
import com.example.demo.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.btnBuyerActivity.setOnClickListener(View.OnClickListener {
            startActivity(Intent(applicationContext,BuyersActivity::class.java))
        })

        binding.btnCounterActivity.setOnClickListener(View.OnClickListener {
            startActivity(Intent(applicationContext,CounterActivity::class.java))
        })

        binding.btnRegisterActivity.setOnClickListener(View.OnClickListener {
            startActivity(Intent(applicationContext,RegisterActivity::class.java))
        })










    }




}