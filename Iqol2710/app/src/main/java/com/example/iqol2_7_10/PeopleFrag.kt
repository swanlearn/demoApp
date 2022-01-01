package com.example.iqol2_7_10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.iqol2_7_10.databinding.PeopleBinding

class PeopleFrag:Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    lateinit var bind:PeopleBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = PeopleBinding.inflate(layoutInflater)
        var data1:ArrayList<data> = arrayListOf(
            data("Jared","jared@jared.company","65 43 2343 4556"),
            data("jennifer","jennifer@awesomemail.com","22 22 2222 2222"),
            data("Laura","laura@epicmail.com","55 55 5555 5555"),
            data("Marcus","marcus@hugemail.com","88 88 8888 8888"),
            data("Mathews","mathews@epicmail.com","44 44 4444 4444"),

        )
        var adaptor = CustomRCV(data1)
        bind.recView.adapter = adaptor
        bind.recView.layoutManager = LinearLayoutManager(requireContext())
        return bind.root
    }
}