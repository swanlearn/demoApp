package com.example.demo.calculator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demo.models.Numbers

class NumbersViewModel : ViewModel() {


    var numbersMutableLiveData = MutableLiveData<Numbers>()

    fun plusNumbers(numbers: Numbers){

        numbers.let {
            numbersMutableLiveData.value=it
        }

    }

}