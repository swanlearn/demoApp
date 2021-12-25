package com.example.tabview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tabview.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var bind:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        bind = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bind.root)

        var tabs = bind.tabs
        var first = tabs.newTab()
        first.text = "First"
        tabs.addTab(first)
        var sec = tabs.newTab()
        sec.text = "Secend"
        tabs.addTab(sec)
        tabs.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab) {
            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                when(tab.position){
                    0 -> {
                        supportFragmentManager.beginTransaction().replace(R.id.frag,first_flag()).commit()
                        Toast.makeText(this@MainActivity,"first",Toast.LENGTH_LONG).show()
                    }
                    1 -> {
                        supportFragmentManager.beginTransaction().replace(R.id.frag,sec_flag()).commit()
                        Toast.makeText(this@MainActivity,"secend",Toast.LENGTH_LONG).show()
                    }

                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
            }
        })

    }
}