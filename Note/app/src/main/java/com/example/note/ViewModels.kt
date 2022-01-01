package com.example.note

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModels : ViewModel() {
    val Iteam: MutableLiveData<ArrayList<String>> = MutableLiveData()
    init {
        Iteam.value = arrayListOf("")
    }
}