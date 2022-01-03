package com.example.web_browser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.FrameLayout
import android.widget.TableLayout
import androidx.activity.viewModels
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val model:viewmodels.activityviewmodel by viewModels()
        var tab:TabLayout
        if(model.frag.value == null){
            supportFragmentManager.beginTransaction().add(R.id.frag_view,BrowserFrag()).commit()
            model.frag.value = supportFragmentManager
        }else{
            supportFragmentManager.fragmentFactory = model.frag.value!!.fragmentFactory
        }

        setContentView(R.layout.activity_main)
        if(model.tab.value == null) {
            tab = findViewById<TabLayout>(R.id.tab_view)
            val brows = tab.newTab()
            brows.text = "Browser"
            tab.addTab(brows)
            val brows1 = tab.newTab()
            brows1.text = "History"
            tab.addTab(brows1)
            val brows2 = tab.newTab()
            brows2.text = "PlayVideo"
            tab.addTab(brows2)
            tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    model.tab_num.value = tab!!.position
                    when(tab!!.position) {
                        0 -> {supportFragmentManager.beginTransaction().replace(R.id.frag_view, BrowserFrag()).commit()

                        }
                        1 ->{
                            supportFragmentManager.beginTransaction().replace(R.id.frag_view,HistoryFrag()).commit()
                        }
                        2->{
                            supportFragmentManager.beginTransaction().replace(R.id.frag_view,startTab()).commit()
                        }
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                }

            })
        }else{
            tab = model.tab.value!!
        }
        if(model.tab_num.value != null) tab.setScrollPosition(model.tab_num.value!!, 0.0F,true)


    }

    override fun onBackPressed() {
        val frag=supportFragmentManager.findFragmentById(R.id.frag_view)
        if(frag is BrowserFrag){
            if(frag.web!!.canGoBack()){
                frag.web!!.goBack()
                return
            }
        }
        super.onBackPressed()
    }
}