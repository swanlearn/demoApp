package com.example.ui28_7class

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.utils.widget.MotionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<MotionButton>(R.id.but1)
        btn.setOnClickListener {
            val intel = Intent(this@MainActivity,TimeAAvtivity::class.java)
            startActivity(intel)
        }
    }
}