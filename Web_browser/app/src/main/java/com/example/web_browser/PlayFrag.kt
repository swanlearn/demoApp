package com.example.web_browser

import android.content.res.Configuration
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.MediaController
import android.widget.VideoView
import androidx.activity.viewModels
import androidx.compose.ui.graphics.Color
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.material.tabs.TabLayout
import java.util.*
import android.media.session.MediaController as Object

class PlayFrag():Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    val share : viewmodels.glob by activityViewModels()
    lateinit var model:viewmodels.playviemodel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.paly,container,false)
        model = ViewModelProvider(this).get(viewmodels.playviemodel::class.java)
        requireActivity().findViewById<TabLayout>(R.id.tab_view).visibility = View.GONE
        if(model.video.value == null) {
            model.video.value = view.findViewById<VideoView>(R.id.play)
            model.video.value!!.setVideoPath(share.link.value)
            model.video.value!!.setMediaController(object :MediaController(requireContext()){})
            model.video.value!!.start()
            model.isplay.value = true
        }else{
            model.video.value = view.findViewById<VideoView>(R.id.play)
            model.video.value!!.setVideoPath(share.link.value)
            model.video.value!!.setMediaController(object :MediaController(requireContext()){})
            //share.video.value!!.seekTo(model.position.value!!)
            model.video.value!!.start()
            model.video.value!!.seekTo(model.position.value!!)
            model.isplay.value = true
        }
        return view
    }

    override fun onPause() {
        model.position.value = model.video.value!!.currentPosition
        super.onPause()
    }



}