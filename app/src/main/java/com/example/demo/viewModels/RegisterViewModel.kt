package com.example.demo.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demo.models.User

class RegisterViewModel:ViewModel() {

    var userMutableLiveData= MutableLiveData<User>()

    fun registerUser(userName:String,email:String,password:String){

        val user = User(userName, email, password)

        userMutableLiveData.value=user



    }

}