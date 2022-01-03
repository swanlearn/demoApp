package com.example.web_browser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistoryFrag:Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.tab2,container,false)
        val rc = view.findViewById<RecyclerView>(R.id.rch)
        val adapt = customAdapter(requireActivity(), history)
        rc.adapter = adapt
        rc.layoutManager = LinearLayoutManager(requireContext())
        return view
    }
}