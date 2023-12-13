package com.example.madteamb.ui.theme

import android.annotation.SuppressLint
import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.madteamb.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("GFG | Audio Player", color = Color.White) }) },
        content = { MyContent() }
    )
}

// Creating a composable function to
// create two icon buttons namely play and pause
// Calling this function as content in the above function
@Composable
fun MyContent(){

    // Fetching the local context
    val mContext = LocalContext.current

    // Declaring and Initializing
    // the MediaPlayer to play "audio.mp3"
    val mMediaPlayer = MediaPlayer.create(mContext, R.raw.audio)

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

        Row {
            // IconButton for Start Action
            IconButton(onClick = { mMediaPlayer.start() }) {
                Icon(painter = painterResource(id = R.drawable.ic_play), contentDescription = "", Modifier.size(100.dp))
            }

            // IconButton for Pause Action
            IconButton(onClick = { mMediaPlayer.pause() }) {
                Icon(painter = painterResource(id = R.drawable.ic_pause), contentDescription = "", Modifier.size(100.dp))
            }
        }
    }
}

// For displaying preview in
// the Android Studio IDE emulator
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainContent()
}
