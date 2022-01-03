package com.example.web_browser

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
                requireActivity().supportFragmentManager.beginTransaction().replace(R.id.frag_view,PlayFrag()).addToBackStack("play").commit()
                share.history.value!!.add(data((text.text.toString())))
            }
        }

        return view
    }
}