package com.example.calucator

import android.util.Log
import android.widget.TextView

class Calucator {
    private lateinit var model:MyViewModel
    private lateinit var input:TextView
    private lateinit var result_:TextView
    private var index  = 0
    private var index2 = 0
    private var val1 :Double= 0.0
    private var val2 :Double ? = null
    private var text:String =""
    private var signal = 0
    private var isone:Boolean = false

    constructor(modl:MyViewModel,input_text:TextView,result_text:TextView){
        model = modl
        input = input_text
        result_ = result_text
    }

    public fun change(){
        index2 = input.length() - 1
        model.text.value  = input.toString()
        if(index == 0 ){
            if(input.text.get(index2) == '+'||input.text.get(index2) == '×'||input.text.get(index2) == '÷')
            {
                backspace()
                return
            }
            if(input.text.get(index2) == '-'){
                text = text.plus('-')
                index ++
                return
            }
        }
        if(index == 1 && text.get(0) == '-' && input.text.get(index2) == '-'){
            backspace()
            return
        }
        when(input.text[index2]){
            in '0'..'9'->{
                text = text.plus(input.text[index2])
                model.isnull.value=false
                index ++
            }
            ','->{
                text = text.plus(".")
                index ++
            }
            '+'->{
                Log.d("Tag","text:$text")
                if(isone == false)val1 = text.toDouble()
                else val2 = text.toDouble()
                isone = true
                reaction()
                signal = 1
            }
            '-'->{
                if(isone == false)val1 = text.toDouble()
                else val2 = text.toDouble()
                isone = true
                reaction()
                signal = 2
            }
            '×'->{
                if(isone == false)val1 = text.toDouble()
                else val2 = text.toDouble()
                isone = true
                reaction()
                signal = 3
            }
            '÷'->{
                if(isone == false)val1 = text.toDouble()
                else val2 = text.toDouble()
                isone = true
                reaction()
                signal = 4
            }
        }
    }
    public fun backspace(){
        if(!input.text.isEmpty()){
            input.text = input.text.toString().dropLast(1)
            model.text.value = input.text.toString()
        }
        if(!text.isEmpty()) {
            text = text.dropLast(1)
            if(index != 0)index --
        }
        else signal = 0
        index2 = input.length() - 1
    }
    public fun  clear(){
        index2 = 0
        index =0
        isone = false
        model.isnull.value = true
    }
    public fun Exit(){
        if(!text.isEmpty())val2 = text.toDouble()
        if(val2 == null){
            text = ""
            index = 0
            return
        }
        when(signal){
            1->sub()
            2->miynes()
            3->mittion()
            4->divition()
        }
        if(model.iserror.value == false)print2()
        model.push(val1)
        clear()
        result_.text = ""
        val2 =null
        index =0
        index2 = input.length()-1
        text =""
    }

    private fun reaction(){
        if(val2 == null){
            text =""
            index =0
            return
        }
        when(signal){
            1->sub()
            2->miynes()
            3->mittion()
            4->divition()
        }
        if(model.iserror.value == false)print2()
        val2 =null
        index =0
        index2 = input.length()-1
        text =""
    }
    private fun sub(){
        Log.d("Tag","text1:$val2")
        if(val2 != null) val1 += val2!!

    }
    private fun miynes(){
        if(val2 != null) val1 -= val2!!
    }
    private fun mittion(){
        if(val2 != null) val1 *= val2!!
    }
    private fun divition(){
        if(val2 != null){
            if(val2 == 0.0){
                model.iserror.value = true
                model.isclear.value =true
                model.text.value = "Error"
                model.push(0.0)
                return
            }
            else {
                Log.d("Tag","val11:$val2")
                val1 = val1 / val2!!
            }
        }
    }
    private fun print2(){
        if(model.iserror.value == false){
            if((val1 - val1.toInt()) == 0.0) result_.text = val1.toInt().toString()
            else{
                var out = String.format("%.14f",val1)
                Log.d("Tag","val:s:$out")
                result_.text = out
            }
        }else result_.text = "Error"
        result_.text = result_.text.toString().replace(".",",")
        model.text2.value = result_.text.toString()
    }

}