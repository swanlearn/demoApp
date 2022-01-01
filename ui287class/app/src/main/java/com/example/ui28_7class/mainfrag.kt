package com.example.ui28_7class

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.utils.widget.MotionButton
import androidx.fragment.app.Fragment

class mainfrag:Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view  = inflater!!.inflate(R.layout.main,container,false)
        val but1 =  view.findViewById<MotionButton>(R.id.but1)
        but1.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.frag_view,timefrag()).commit()
        }
        return view
    }
}