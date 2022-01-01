package com.example.xam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class EnginFrag:Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater!!.inflate(R.layout.engin,container,false)
        val  btn1 = view.findViewById<MaterialButton>(R.id.e_btn1)
        val  btn2 = view.findViewById<MaterialButton>(R.id.e_btn2)
        val  btn3 = view.findViewById<MaterialButton>(R.id.e_btn3)

        btn1.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.frag_view,TimeFrag()).addToBackStack("time").commit()
        }
        btn2.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.frag_view,TimeFrag()).addToBackStack("time").commit()
        }
        btn3.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.frag_view,TimeFrag()).addToBackStack("time").commit()
        }

        return view
    }
}
