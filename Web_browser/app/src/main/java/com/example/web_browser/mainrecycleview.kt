package com.example.web_browser

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class mainrecycleview:ViewModel() {
    val link = MutableLiveData<String>("")
}