package com.example.emergencymap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayerView
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.internal.o
import com.google.android.youtube.player.internal.v
import kotlinx.android.synthetic.main.activity_howto_aed.*

class HowToAED : YouTubeBaseActivity() {
    companion object{
        val VIDEO_ID : String = "A_3fH2zZ9i4";
        val YOUTUBE_API_KEY: String = "AIzaSyDMvyFMCLyeilRPFf4WHuge72wUg6eXZJ4"
    }
    lateinit var youtubePlayerInit: YouTubePlayer.OnInitializedListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_howto_aed)
        setTitle("AED사용법")
        initUI()
    }
    private fun initUI() {
        youtubePlayerInit = object :YouTubePlayer.OnInitializedListener{
            override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, youTubePlayer: YouTubePlayer, p2: Boolean) {
                youTubePlayer.loadVideo(VIDEO_ID)
            }

            override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
            Toast.makeText(applicationContext, "something went worng", Toast.LENGTH_SHORT).show()
            }
        }
        playaedvideo.setOnClickListener(View.OnClickListener { v ->
            youtube_view.initialize(YOUTUBE_API_KEY, youtubePlayerInit)
        })
    }
}
