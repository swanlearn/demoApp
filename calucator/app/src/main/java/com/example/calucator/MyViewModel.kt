package com.example.calucator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    val math = MutableLiveData<Calucator>(null)
    val val1 = MutableLiveData<Double>(0.0)
    val iserror = MutableLiveData<Boolean>(false)
    val isnull = MutableLiveData<Boolean>(true)
    val isclear = MutableLiveData<Boolean>(false)
    val text = MutableLiveData<String>("")
    val text2 = MutableLiveData<String>("")

    public fun clear(){
        val1.value =0.0
        isclear.value =false
        isnull.value=true
        iserror.value=false
    }
    public fun push(index:Double){
        val1.value = index
    }
}