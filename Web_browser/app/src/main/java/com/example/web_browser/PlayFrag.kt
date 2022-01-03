package com.example.web_browser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.VideoView
import androidx.compose.ui.graphics.Color
import androidx.fragment.app.Fragment

class PlayFrag:Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    public var link:String=""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.paly,container,false)
        val video = view.findViewById<VideoView>(R.id.play)
        val btn = view.findViewById<ImageButton>(R.id.playbtn)
        var paly:Boolean = false
        link = linkm
        video.setVideoPath(link)
        video.start()
        if(paly == false){

            btn.setBackgroundResource(R.drawable.ic_baseline_play_circle_outline_24)
            btn.setImageResource(R.drawable.ic_baseline_play_circle_outline_24)
        }
        else {

            btn.setBackgroundResource(R.drawable.ic_baseline_pause_24)
            btn.setImageResource(R.drawable.ic_baseline_pause_24)
        }
        paly = video.isPlaying
        btn.setOnClickListener {
            paly = video.isPlaying
            if(paly == false){
                video.resume()
                btn.setBackgroundResource(R.drawable.ic_baseline_play_circle_outline_24)
                btn.setImageResource(R.drawable.ic_baseline_play_circle_outline_24)
            }
            else {
                video.pause()
                btn.setBackgroundResource(R.drawable.ic_baseline_pause_24)
                btn.setImageResource(R.drawable.ic_baseline_pause_24)
            }
        }
        return view
    }
}