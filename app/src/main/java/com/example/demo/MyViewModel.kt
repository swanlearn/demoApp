package com.example.demo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    val counterMutableLiveData=MutableLiveData<Int>(0)


    fun addCounter(){



       counterMutableLiveData.value= counterMutableLiveData.value?.plus(1)



    }



}