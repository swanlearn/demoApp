package com.example.xam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.FrameLayout
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val frag = findViewById<FrameLayout>(R.id.frag_view)
        supportFragmentManager.beginTransaction().add(R.id.frag_view,userfrag()).commit()
        supportActionBar!!.hide()
        val tab = findViewById<TabLayout>(R.id.tab_view)
        var first = tab.newTab()
        first.text = "User"
        tab.addTab(first)
        var sec = tab.newTab()
        sec.text = "Manager"
        tab.addTab(sec)
        tab.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab!!.position){
                    0->{        supportFragmentManager.beginTransaction().replace(R.id.frag_view,userfrag()).commit()

                    }
                    1->{
                        supportFragmentManager.beginTransaction().replace(R.id.frag_view,ManagerFrag()).commit()

                    }

                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }


        })
    }

    override fun onBackPressed() {
        val fragm = supportFragmentManager.findFragmentById(R.id.frag_view)
        val tab = findViewById<TabLayout>(R.id.tab_view)
            if(fragm is HomeFrag){
                tab.visibility = View.VISIBLE
            }
        super.onBackPressed()
    }

}