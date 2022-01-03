package com.example.web_browser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.TableLayout
import androidx.activity.viewModels
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val model:mainrecycleview by viewModels()
        setContentView(R.layout.activity_main)
        val tab = findViewById<TabLayout>(R.id.tab_view)
        val brows = tab.newTab()
        brows.text = "Browser"
        tab.addTab(brows)
        val brows1 = tab.newTab()
        brows1.text = "Browser1"
        tab.addTab(brows1)
        val brows2 = tab.newTab()
        brows2.text = "Browser2"
        tab.addTab(brows2)

        tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab!!.position) {
                    0 -> {supportFragmentManager.beginTransaction().replace(R.id.frag_view, BrowserFrag())
                        .commit()}
                    1 ->{
                        supportFragmentManager.beginTransaction().replace(R.id.frag_view,HistoryFrag()).commit()
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
        supportFragmentManager.beginTransaction().replace(R.id.frag_view,BrowserFrag()).commit()
    }

    override fun onBackPressed() {
        val frag=supportFragmentManager.findFragmentById(R.id.frag_view)
        if(frag is BrowserFrag){
            if(frag.web.canGoBack()){
                frag.web.goBack()
                return
            }
        }
        super.onBackPressed()
    }
}