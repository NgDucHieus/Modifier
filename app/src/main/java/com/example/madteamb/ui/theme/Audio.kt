package com.example.madteamb.ui.theme

import android.media.MediaPlayer
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.madteamb.R



@Composable
fun LaunchSound(){

    // Fetching the local context
    val mContext = LocalContext.current

    // Declaring and Initializing
    // the MediaPlayer to play "audio.mp3"
    val mMediaPlayer = MediaPlayer.create(mContext, R.raw.audio)
    mMediaPlayer.start()

}

