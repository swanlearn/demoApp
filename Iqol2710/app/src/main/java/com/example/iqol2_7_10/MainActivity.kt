package com.example.iqol2_7_10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.frag_view,HomeFrag()).commit()
        val nav = findViewById<NavigationView>(R.id.nav_view)
        val nav_view = nav.getHeaderView(0)
        val but1 = nav_view.findViewById<AppCompatButton>(R.id.profilebtn)
        val but2 = nav_view.findViewById<AppCompatButton>(R.id.reportbtn)
        val but3 = nav_view.findViewById<AppCompatButton>(R.id.secbtn)
        val but4 = nav_view.findViewById<AppCompatButton>(R.id.setbtn)
        val but5 = nav_view.findViewById<AppCompatButton>(R.id.pepbtn)
        but1.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.frag_view,changeprofile_frag()).commit()
        }
        but2.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.frag_view,ReportFrag()).commit()
        }
        but4.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.frag_view,welcomeFrag()).commit()
        }
        but3.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.frag_view,ResultFrag()).commit()
        }
        but5.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.frag_view,PeopleFrag()).commit()
        }
    }
}