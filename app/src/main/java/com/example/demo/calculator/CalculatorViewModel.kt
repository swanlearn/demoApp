package com.example.demo.calculator

import android.text.Editable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel:ViewModel() {

    var calculatorMutableLiveData = MutableLiveData<Double>()

    fun plusNumbers(a: Double, b:Double){
        calculatorMutableLiveData.value=a+b

    }

    fun minusNumbers(a:Double,b:Double){
        calculatorMutableLiveData.value=a-b
    }

    fun productNumbers(a:Double,b:Double){
        calculatorMutableLiveData.value=a*b
    }
    fun divideNumbers(a:Double,b:Double){
        calculatorMutableLiveData.value=a/b
    }





}