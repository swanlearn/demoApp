package com.example.design27_9vclass

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)
        var option = findViewById(R.id.spiner) as Spinner
        val res: Resources = resources
        val options = res.getStringArray(R.array.planets_array)

        option.adapter = ArrayAdapter<String>(this, R.layout.myspiner, options)

        var but =  findViewById<LinearLayout>(R.id.exit)
        but.setOnClickListener {
            val home2 = Intent(this@MainActivity,Home2Activity::class.java)
            startActivity(home2)
        }
    }
}