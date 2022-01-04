package com.example.web_browser

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.textfield.TextInputEditText

class startTab():Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    lateinit var model:viewmodels.activityviewmodel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.tab3,container,false)
        val text = view.findViewById<TextInputEditText>(R.id.loadtext)
        val btn = view.findViewById<MaterialButton>(R.id.load)
        val share : viewmodels.glob by activityViewModels()
        requireActivity().findViewById<TabLayout>(R.id.tab_view).visibility = View.VISIBLE
        btn.setOnClickListener {
            if(text.text!!.isNotEmpty()){
                share.link.value = text.text.toString()
                val uri = Uri.parse(text.text.toString())
                Thread(Runnable {
                    var nametext =""
                    for (i in (uri.toString().length-1) downTo 0){
                        if(uri.toString()[i]=='/') {
                            for (j in i+1 .. (uri.toString().length-1)){
                                nametext += uri.toString()[j]
                                if(uri.toString()[j]=='/')break
                            }
                            break
                        }
                    }
                    nametext = nametext.replace("%20",".")
                    share.history.value!!.add(data(uri.toString(),nametext))
                }).start()
                requireActivity().supportFragmentManager.beginTransaction().replace(R.id.frag_view,PlayFrag()).addToBackStack("play").commit()
            }
        }

        return view
    }
}