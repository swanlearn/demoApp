package com.example.xam

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import java.text.SimpleDateFormat
import java.util.*

class ReportFrag:Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    lateinit var tred :Thread
    var en = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater!!.inflate(R.layout.report,container,false)
        val dat = view.findViewById<TextView>(R.id.date)
        val time= view.findViewById<TextView>(R.id.time)
        var date = Date()

        val formatter = SimpleDateFormat("yyyy/MM/dd EEE")
        dat.text =formatter.format(date).toString()
        val format2 = SimpleDateFormat("HH:mm:ss")
        time.text = format2.format(date).toString()
        val draw = view.findViewById<ImageButton>(R.id.im1)
        draw.setOnClickListener {
            Toast.makeText(requireContext(),"a",Toast.LENGTH_SHORT).show()
            val dialog = Dialog(requireContext())
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.paint)

            dialog.show()
            val save = dialog.findViewById<MaterialButton>(R.id.sv_btn)
            save.setOnClickListener {
                dialog.dismiss()
            }
        }
        en =true
        tred=Thread(Runnable {
            while (true) {
                // Updating Text View at current
                if(en == true){requireActivity().runOnUiThread{
                    var date = Date()
                    val format2 = SimpleDateFormat("HH:mm:ss")
                    time.text = format2.format(date).toString()
                }
                Thread.sleep(1000)
            }}
        })
        tred.start()

        return view
    }

    override fun onStop() {
        en =false
        super.onStop()
    }
}