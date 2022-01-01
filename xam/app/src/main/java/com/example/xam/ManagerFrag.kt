package com.example.xam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.utils.widget.MotionButton
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout

class ManagerFrag:Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater!!.inflate(R.layout.manager,container,false)
        val btn = view.findViewById<MaterialButton>(R.id.login)
        val tab=requireActivity().findViewById<TabLayout>(R.id.tab_view)
        btn.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.frag_view,HomeFrag()).addToBackStack("home").commit()
            tab.visibility = View.GONE
        }
        return view
    }
}