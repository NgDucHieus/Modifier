package com.example.madteamb.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.madteamb.R
import com.example.madteamb.model.Timer.TimerViewModel
import com.example.madteamb.ui.theme.Coin.Coin
import com.example.madteamb.ui.theme.ext.Timer


@Composable
fun mainScreen()
{
    Column(
        Modifier
            .background(GreenBackGround)) {
        Spacer(modifier = Modifier.height(10.dp))
        Timer()
    }
}

@Preview
@Composable
fun Previewtest()
{
    mainScreen()
}