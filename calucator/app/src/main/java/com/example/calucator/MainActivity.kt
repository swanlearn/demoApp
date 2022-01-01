package com.example.calucator

import android.app.Activity
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.example.calucator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bind : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        bind = ActivityMainBinding.inflate(layoutInflater)
        val model : MyViewModel by viewModels()
        model.math.value = Calucator(model,bind.text1,bind.text2)
        super.onCreate(savedInstanceState)
        setContentView(bind.root)
        bind.num0.setOnClickListener {
            if(model.iserror.value == true) {
                model.clear()
                bind.text1.text = ""
                bind.c.visibility = View.INVISIBLE
                bind.back.visibility = View.VISIBLE
            }
            bind.text1.text = bind.text1.text.toString().plus("0")
            model.math.value!!.change()
        }
        bind.num1.setOnClickListener {
            if(model.iserror.value == true) {
                model.clear()
                bind.text1.text = ""
                bind.c.visibility = View.INVISIBLE
                bind.back.visibility = View.VISIBLE
            }
            bind.text1.text = bind.text1.text.toString().plus("1")
            model.math.value!!.change()
        }
        bind.num2.setOnClickListener {
            if(model.iserror.value == true) {
                model.clear()
                bind.text1.text = ""
                bind.c.visibility = View.INVISIBLE
                bind.back.visibility = View.VISIBLE
            }
            bind.text1.text = bind.text1.text.toString().plus("2")
            model.math.value!!.change()
        }
        bind.num3.setOnClickListener {
            if(model.iserror.value == true) {
                model.clear()
                bind.text1.text = ""
                bind.c.visibility = View.INVISIBLE
                bind.back.visibility = View.VISIBLE
            }
            bind.text1.text = bind.text1.text.toString().plus("3")
            model.math.value!!.change()
        }
        bind.num4.setOnClickListener {
            if(model.iserror.value == true) {
                model.clear()
                bind.text1.text = ""
                bind.c.visibility = View.INVISIBLE
                bind.back.visibility = View.VISIBLE
            }
            bind.text1.text = bind.text1.text.toString().plus("4")
            model.math.value!!.change()
        }
        bind.num5.setOnClickListener {
            if(model.iserror.value == true) {
                model.clear()
                bind.text1.text = ""
                bind.c.visibility = View.INVISIBLE
                bind.back.visibility = View.VISIBLE
            }
            bind.text1.text = bind.text1.text.toString().plus("5")
            model.math.value!!.change()
        }
        bind.num6.setOnClickListener {
            if(model.iserror.value == true) {
                model.clear()
                bind.text1.text = ""
                bind.c.visibility = View.INVISIBLE
                bind.back.visibility = View.VISIBLE
            }
            bind.text1.text = bind.text1.text.toString().plus("6")
            model.math.value!!.change()
        }
        bind.num7.setOnClickListener {
            if(model.iserror.value == true) {
                model.clear()
                bind.text1.text = ""
                bind.c.visibility = View.INVISIBLE
                bind.back.visibility = View.VISIBLE
            }
            bind.text1.text = bind.text1.text.toString().plus("7")
            model.math.value!!.change()
        }
        bind.num8.setOnClickListener {
            if(model.iserror.value == true) {
                model.clear()
                bind.text1.text = ""
                bind.c.visibility = View.INVISIBLE
                bind.back.visibility = View.VISIBLE
            }
            bind.text1.text = bind.text1.text.toString().plus("8")
            model.math.value!!.change()
        }
        bind.num9.setOnClickListener {
            if(model.iserror.value == true) {
                model.clear()
                bind.text1.text = ""
                bind.c.visibility = View.INVISIBLE
                bind.back.visibility = View.VISIBLE
            }
            bind.text1.text = bind.text1.text.toString().plus("9")
            model.math.value!!.change()
        }
        bind.ndot.setOnClickListener {
            if(model.iserror.value == true) {
                model.clear()
                bind.text1.text = ""
                bind.c.visibility = View.INVISIBLE
                bind.back.visibility = View.VISIBLE
            }
            if(!bind.text1.text.isEmpty()) {
                bind.text1.text = bind.text1.text.toString().plus(",")
                model.math.value!!.change()
            }
        }
        bind.Total.setOnClickListener {
            if(!bind.text1.text.isEmpty()&&model.iserror.value == false){
                bind.text1.text =bind.text1.text.toString().plus("+")
                model.math.value!!.change()
            }
        }
        bind.Submission.setOnClickListener {
            if(model.iserror.value == false){
                bind.text1.text =bind.text1.text.toString().plus("-")
                model.math.value!!.change()
            }
        }
        bind.Multiplication.setOnClickListener {
            if(!bind.text1.text.isEmpty()&&model.iserror.value == false){
                bind.text1.text =bind.text1.text.toString().plus("×")
                model.math.value!!.change()
            }
        }
        bind.Division.setOnClickListener {
            if(!bind.text1.text.isEmpty()&&model.iserror.value == false){
                bind.text1.text =bind.text1.text.toString().plus("÷")
                model.math.value!!.change()
            }
        }
        bind.back.setOnClickListener{model.math.value!!.backspace()}
        bind.c.setOnClickListener {
            model.clear()
            bind.text1.text=""
            bind.text2.text=""
            model.text.value = ""
            model.text2.value = ""
            bind.c.visibility = View.INVISIBLE
            bind.back.visibility = View.VISIBLE
            model.math.value!!.clear()
        }
        bind.result.setOnClickListener {
            model.isclear.value = true
            model.math.value!!.Exit()
        }
        model.val1.observe(this,{
            bind.text2.text = model.text2.value
            bind.text1.text = model.text.value
            Log.d("tag","iserror:${model.iserror.value}")
            if(model.iserror.value == true){
                bind.c.visibility = View.VISIBLE
                bind.back.visibility = View.INVISIBLE
                bind.text1.text = "Error"
                bind.text2.text = ""
                return@observe
            }
            if(model.isclear.value == true){
                bind.c.visibility = View.VISIBLE
                bind.back.visibility = View.INVISIBLE
            }
            if(model.isnull.value != true){
                if((it - it.toInt()) == 0.0)bind.text1.text = it.toInt().toString()
                else{
                    bind.text1.text = it.toString()
                    val out = String.format("%.14f",model.val1.value)
                    if((it-out.toDouble()) != 0.0)bind.text1.text = out
                }
                bind.text1.text = bind.text1.text.toString().replace(".",",")
            }
            else {
                bind.text1.text = ""
                bind.text2.text = ""
            }
        })
    }
}
