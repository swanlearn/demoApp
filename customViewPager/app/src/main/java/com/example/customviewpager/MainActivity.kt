package com.example.customviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewpage = findViewById<ViewPager>(R.id.view_pager)
        val adapter = PageAdapter(supportFragmentManager)
        viewpage.adapter = adapter
        val tab = findViewById<TabLayout>(R.id.tab_view)
        tab.setupWithViewPager(viewpage)
    }
}