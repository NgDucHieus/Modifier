package com.example.madteamb.ui.theme

import androidx.compose.runtime.Composable
import MuneerCircularProgressBar
import androidx.compose.ui.tooling.preview.Preview
import com.example.madteamb.model.TimerViewModel

@Composable
fun mainScreen()
{   
    var timerState:TimerViewModel

    MuneerCircularProgressBar(onProgressChanged = {})

}

@Preview
@Composable
fun Previewtest()
{
    mainScreen()
}