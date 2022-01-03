package com.example.web_browser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout

class HistoryFrag:Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().findViewById<TabLayout>(R.id.tab_view).visibility = View.VISIBLE
        val view = inflater.inflate(R.layout.tab2,container,false)
        val rc = view.findViewById<RecyclerView>(R.id.rch)
        val share : viewmodels.glob by activityViewModels()
        val dataa : ArrayList<data> = share.history.value!!
        val adapt = customAdapter(requireActivity(), dataa,share)
        rc.adapter = adapt
        rc.layoutManager = LinearLayoutManager(requireContext())
        return view
    }
}