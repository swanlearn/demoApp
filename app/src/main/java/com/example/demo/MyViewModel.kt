package com.example.demo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MyViewModel : ViewModel() {

    var counter = MutableLiveData<Int>(0)

    fun increment() {
        counter.value = counter.value?.plus(1)
    }
}