package com.example.web_browser

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import android.widget.VideoView
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.tabs.TabLayout

class viewmodels {
    class glob:ViewModel(){
        val history = MutableLiveData<ArrayList<data>>(arrayListOf())
        val link = MutableLiveData<String>("")
        val bund = MutableLiveData<Bundle>(Bundle())


    }
    class playviemodel:ViewModel(){
        val video=MutableLiveData<VideoView>(null)
        var isplay=MutableLiveData<Boolean>(false)
        var link=MutableLiveData<String>("")
        val position=MutableLiveData<Int>(null)
    }
    class activityviewmodel:ViewModel(){
        val videolink = MutableLiveData<String>("")
        val tab = MutableLiveData<TabLayout>(null)
        val tab_num = MutableLiveData<Int>(null)
        val frag = MutableLiveData<FragmentManager>(null)
    }
}