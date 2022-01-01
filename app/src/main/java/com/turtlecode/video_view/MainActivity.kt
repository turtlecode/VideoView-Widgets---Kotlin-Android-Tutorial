package com.turtlecode.video_view

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView

class MainActivity : AppCompatActivity() {

    var simpleVideoView: VideoView? = null
    var mediaControls: MediaController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        simpleVideoView = findViewById<View>(R.id.simpleVideoView) as VideoView
        if (mediaControls == null) {
            mediaControls = MediaController(this)
            mediaControls!!.setAnchorView(this.simpleVideoView)
        }

        simpleVideoView!!.setMediaController(mediaControls)
        simpleVideoView!!.setVideoURI(
            Uri.parse("android.resource://"
                + packageName + "/" + R.raw.video))

        simpleVideoView!!.requestFocus()

        simpleVideoView!!.start()

        simpleVideoView!!.setOnCompletionListener {
            Toast.makeText(applicationContext, "Video completed",
                Toast.LENGTH_LONG).show()
        }
        simpleVideoView!!.setOnErrorListener { mp, what, extra ->
            Toast.makeText(applicationContext, "An Error Occured " +
                    "While Playing Video !!!", Toast.LENGTH_LONG).show()
            false
        }
    }
}
