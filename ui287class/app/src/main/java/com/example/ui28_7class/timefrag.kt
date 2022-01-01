package com.example.ui28_7class

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.utils.widget.MotionButton
import androidx.fragment.app.Fragment

class timefrag:Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater!!.inflate(R.layout.time,container,false)
        val but1 = view.findViewById<MotionButton>(R.id.but3)
        but1.setOnClickListener {
            Toast.makeText(requireContext(),"00:02",Toast.LENGTH_SHORT).show()
        }
        return  view
    }
}