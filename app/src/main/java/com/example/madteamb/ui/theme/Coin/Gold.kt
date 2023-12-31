package com.example.madteamb.ui.theme.Coin

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.madteamb.ui.theme.GreenBackGround
import com.example.madteamb.R
import com.example.madteamb.model.Timer.Status
import com.example.madteamb.model.Timer.TimerModel
import com.example.madteamb.model.Timer.TimerViewModel


@Composable
fun Coin(retrievedGoldValue:Int) {

    Row(  modifier = Modifier
        .padding(10.dp)
        .size(70.dp, 20.dp)
        .clip(RoundedCornerShape(10.dp))
        .background(Color.White)
        .fillMaxWidth()) {

                Text(
                    text = retrievedGoldValue.toString(),
                    color = GreenBackGround,
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Image(painter = painterResource(id = R.drawable.iconscoin), contentDescription = null )
        }

}
@Preview
@Composable
fun PreviewCoin()
{
//    Coin(viewModel = TimerViewModel((100.toLong())),time =1000)
}

