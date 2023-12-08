package com.example.madteamb.ui.theme.ext

import java.time.Duration
import android.os.Build
import kotlin.math.abs


fun Duration.format():String
{
    val seconds = abs(seconds)
    var value = String.format(
        "%02d:%02d",
        seconds % 3600/60,
        seconds % 60
    )
    if(seconds % (3600.toLong()) >=60.toLong())
    {
        value = String.format(
            "%02d:%02d",
            seconds /60,
            seconds % 60
        )
    }

    return value
}