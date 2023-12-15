package com.example.madteamb.NavigationItem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.sourceInformationMarkerEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.madteamb.R
import com.example.madteamb.model.Timer.TimerViewModel
import com.example.madteamb.ui.theme.Coin.Coin
import com.example.madteamb.ui.theme.GreenBackGround

@Composable
fun AppBar2(
    onNavigationIconClick:() ->Unit
)
{
    Row(modifier = Modifier.fillMaxWidth())
    {
        IconButton(onClick =onNavigationIconClick,
            modifier =  Modifier.padding(start = 10.dp)

        ) {
            Icon(imageVector = Icons.Default.Menu,
                contentDescription = "Toggle Drawer",
                tint = Color.White,
                modifier = Modifier.size(50.dp)
            ) }
    }

}

@Preview
@Composable
fun PreviewApp()
{
    AppBar2 {

    }
}