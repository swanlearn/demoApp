package com.example.demo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.demo.R
import com.example.demo.databinding.ActivityRegisterBinding

import com.example.demo.viewModels.RegisterViewModel

class RegisterActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityRegisterBinding
    lateinit var registerViewModel: RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        binding.executePendingBindings()



        registerViewModel= ViewModelProvider(this).get(RegisterViewModel::class.java)

        val username = binding.txtName.text.toString()
        val email = binding.txtEmail.text.toString()
        val password = binding.txtPassword.text.toString()

        registerViewModel.registerUser(username,email,password)



        binding.btnRegister.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        registerViewModel.userMutableLiveData.observe(this  , Observer {

            val bundle = Bundle()
            bundle.putString("name", it.userName)
            bundle.putString("password", it.password)
            bundle.putString("email", it.email)

            val intent = Intent(applicationContext, OTPActivity::class.java)
            startActivity(intent)

        })
    }
}