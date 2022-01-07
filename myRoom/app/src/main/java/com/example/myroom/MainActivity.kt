package com.example.myroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.myroom.UDao
import com.example.myroom.AppDataBase

class MainActivity : AppCompatActivity() {
lateinit var valuedb:AppDataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val valuedb = AppDataBase.getInstance(application).UDao()
        var  listvalue :List<iteam> = valuedb.getAll()
        val  rcv = findViewById<RecyclerView>(R.id.rcv)
        val adapt = adapterrcv(listvalue)
        rcv.adapter = adapt
        rcv.layoutManager = LinearLayoutManager(this)
        val  btn = findViewById<FloatingActionButton>(R.id.floatbut)

        btn.setOnClickListener {
           valuedb.insert(iteam(0,"sa+${listvalue.size.toString()}"))
            listvalue =valuedb.getAll()
            val adapt = adapterrcv(listvalue)
            rcv.adapter = adapt
            adapt.notifyDataSetChanged()
        }
    }

}
