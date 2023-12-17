package com.example.madteamb.ui.theme.ext

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.madteamb.model.Timer.TimerModel
import com.example.madteamb.model.Timer.TimerViewModel
import com.example.madteamb.ui.theme.GreenBackGround
import MuneerCircularProgressBar
import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import com.example.madteamb.NavigationItem.AppBar2
import com.example.madteamb.NavigationItem.DrawerBody
import com.example.madteamb.NavigationItem.DrawerHeader
import com.example.madteamb.NavigationItem.MenuItem
import com.example.madteamb.NavigationItem.PlayMusic
import com.example.madteamb.model.Timer.Status
import com.example.madteamb.ui.theme.Coin.Coin
import com.example.madteamb.ui.theme.Coin.StoreGold
import com.example.madteamb.ui.theme.Dialog
import com.example.madteamb.ui.theme.GreenCircle
import com.example.madteamb.ui.theme.LaunchSound
import com.example.madteamb.ui.theme.mainScreen
import kotlinx.coroutines.launch
import java.sql.Time

@Composable
fun TimerHomeScreen(viewModel: TimerViewModel,gold: StoreGold,time:Long)
{

        val timer by viewModel.viewState.observeAsState(TimerModel())
        Column(
            modifier = Modifier
                .background(GreenBackGround),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TimerTopSection(time = timer.timeDuration.format())

            // Pass the reference to isCircularProgressBarVisible to TimerButton
            TimerButton(viewModel,timer, gold = gold, time = time)

            // Display the circular progress bar only if isCircularProgressBarVisible is true
        }
    }

@Composable
fun TimerTopSection(time:String)
{
        Text(
            text = time,
            fontSize = 60.sp,
            color = Color.White,
            fontWeight = FontWeight.Thin
        )

}


@SuppressLint("UnrememberedMutableState")
@Composable
fun TimerButton(timerState: TimerViewModel,timer:TimerModel,gold: StoreGold,time:Long) {

    Box() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            when (timer?.status) {
                Status.FINSIHED -> {
                    LaunchSound()
                    println("Done")
                    NewButton(
                        onClick = {
                            timerState.buttonselection()

                        }
                    )
                    Dialog(gold = gold,time)
                }

                Status.RUNNING -> {
                    ResetButton(
                        timerState = timerState,
                        onClick = {
                            timerState.resetTimer()

                        }
                    )
                }

                Status.STARTED -> {
                    StartButton(
                        onClick = {
                            timerState.buttonselection()
                            // Update isResetButtonVisible to true to show ResetButton
                        }
                    )
                }

                else -> {

                }

            }
        }

    }
}
        // Return the value to control the visibility of MuneerCircularProgressBar

@Composable
fun StartButton(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            )
            .padding(10.dp)
            .size(80.dp, 30.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(GreenBackGround)
    ) {
        Text(
            text = "Start",
            color = Color.White,
            modifier = Modifier.align(Alignment.Center),
            fontSize = 13.sp,

        )
    }
}
@Composable
fun NewButton(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            )
            .padding(10.dp)
            .size(80.dp, 30.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(GreenCircle)
    ) {
        Text(
            text = "New Session",
            color = Color.White,
            modifier = Modifier.align(Alignment.Center),
            fontSize = 24.sp,

            )
    }
}
@Composable
fun ResetButton(timerState: TimerViewModel, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
            ) {
                onClick()
            }
            .padding(10.dp)
            .size(80.dp, 30.dp)
            .clip(RoundedCornerShape(7.dp))
            .background(GreenCircle)
            .border(2.dp, GreenBackGround, shape = RoundedCornerShape(5.dp))
            .fillMaxWidth()
    ) {

        Text(
            text = "Cancel", color = Color.Black, modifier = Modifier
                .align(Alignment.Center),
            fontSize = 24.sp
        )
    }
}
@Preview
@Composable
fun PreviewButton()
{
    ResetButton(timerState = TimerViewModel(1000)) {

    }
}

@Preview
@Composable
fun Previewtimer()
{
    Timer()
}
@Composable
fun Timer()
{

    var angle:Long by remember {
        mutableStateOf(0L)
    }
    var timer:TimerViewModel
    var time:Long by remember {
        mutableStateOf(0)
    }
    val context = LocalContext.current
    val gold = remember {
        StoreGold(context = context)
    }

    time = (angle/4)*60 +10*60-9*60
    timer = TimerViewModel(time)


    Column(
        Modifier
            .fillMaxSize()
            .background(GreenBackGround)) {
        Row {
            Spacer(modifier = Modifier.width(290.dp))
            Coin(gold.getGoldValue())
        }

        angle = MuneerCircularProgressBar(onProgressChanged = {}, timerViewModel = timer)
        TimerHomeScreen(viewModel = timer, gold = gold,time =time)
    }
}




