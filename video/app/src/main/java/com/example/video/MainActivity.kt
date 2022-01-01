package com.example.video

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val video = findViewById<VideoView>(R.id.v)
        val uri: Uri =
            Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ex)
      //  video.setVideoURI(uri)
        video.setVideoPath(assets.locales[0])

        video.requestFocus()
        assets.locales[0]
        video.start()
    }
}