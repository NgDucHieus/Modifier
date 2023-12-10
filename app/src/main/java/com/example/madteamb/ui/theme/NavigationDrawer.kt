package com.example.madteamb.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DrawerHeader()
{
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 64.dp),
       contentAlignment = Alignment.Center
    )
    {
       Text(text = "Header", fontSize = 60.sp)

    }
}

@Composable
fun DrawerBody()
{

}
