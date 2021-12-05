package com.example.demo.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    val counterMutableLiveData=MutableLiveData<Int>(0)
  //  private var counter:Int=0

    fun addCounter(){

    //  counter++

       counterMutableLiveData.value= counterMutableLiveData.value?.plus(1)



    }



}