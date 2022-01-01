package com.example.xam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class OutFrag:Fragment (){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater!!.inflate(R.layout.output,container,false)
        val back =  view.findViewById<MaterialButton>(R.id.r_btn1)
        back.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.frag_view,HomeFrag()).commit()
        }
        return view
    }
}