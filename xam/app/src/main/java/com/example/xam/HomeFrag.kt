package com.example.xam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class HomeFrag:Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater!!.inflate(R.layout.home, container, false)
        val btn_engin = view.findViewById<ImageButton>(R.id.btn3)
        val btn_over = view.findViewById<ImageButton>(R.id.btn4)
        val btn_profile = view.findViewById<ImageButton>(R.id.btn9)
        val  btn4 = view.findViewById<ImageButton>(R.id.btn6)
        btn_engin.setOnClickListener {

            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.frag_view, EnginFrag()).addToBackStack("engin").commit()
        }
        btn_over.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.frag_view, OutFrag()).addToBackStack("output").commit()
        }
        btn_profile.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.frag_view, ProfileFrag()).addToBackStack("profile").commit()

        }
        btn4.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.frag_view, archive()).addToBackStack("archive").commit()
        }

        return view
    }


}