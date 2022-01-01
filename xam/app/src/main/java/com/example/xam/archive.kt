package com.example.xam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xam.databinding.ArchiveBinding

class archive:Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    lateinit var bind:ArchiveBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = ArchiveBinding.inflate(layoutInflater)
            var datal = arrayListOf<datas>(datas("Date : 00/05/15","Time : 22:30","Username : aliahmadi","File Name : 2015"),
                datas("Date : 00/05/15","Time : 22:30","Username : aliahmadi","File Name : 2015"),
                datas("Date : 00/05/15","Time : 22:30","Username : aliahmadi","File Name : 2015"),
                datas("Date : 00/05/15","Time : 22:30","Username : aliahmadi","File Name : 2015"),
                datas("Date : 00/05/15","Time : 22:30","Username : aliahmadi","File Name : 2015"),
                datas("Date : 00/05/15","Time : 22:30","Username : aliahmadi","File Name : 2015"),
                datas("Date : 00/05/15","Time : 22:30","Username : aliahmadi","File Name : 2015"),)
        bind.rcv.layoutManager = LinearLayoutManager(requireContext())
        var adpt = CustumAdapter(datal)
        bind.rcv.adapter = adpt

        return bind.root
    }
}