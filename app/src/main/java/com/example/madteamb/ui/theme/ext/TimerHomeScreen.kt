package com.example.madteamb.ui.theme.ext

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.madteamb.R
import com.example.madteamb.model.ButtonState
import com.example.madteamb.model.TimerModel
import com.example.madteamb.model.TimerViewModel

@Composable
fun TimerHomeScreen(viewModel: TimerViewModel)
{
    val timer by viewModel.viewState.observeAsState(TimerModel())
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Black),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TimerHeader()
        Spacer(modifier = Modifier.height(25.dp))
        TimerTopSection(time = timer.timeDuration.format(), remainingTime = timer.remaingTime)
        Spacer(modifier =Modifier.height(25.dp))
        TimerButton(viewModel)

    }

}
@Composable
fun TimerTopSection(time:String,remainingTime:Long)
{
    val infiniteTransition = rememberInfiniteTransition()
    val alpha by infiniteTransition.animateColor(
        initialValue = Color.Red,
        targetValue = Color.Green,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = time,
            fontSize = 60.sp,
            color = if(isTimeLessThan10seconds(remainingTime)){alpha} else Color.White
        )
    }
}
@Composable
fun TimerHeader()
{
    Text(
        text = "Count Down Timer",
        fontSize = 30.sp,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 80.dp),
        style = MaterialTheme.typography.titleMedium
    )
}
private fun isTimeLessThan10seconds(time:Long) = time < 10000L

@Composable
fun TimerButton(timerState:TimerViewModel)
{
    val toggle by timerState.viewState.observeAsState()
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    )
    {
        IconButton(onClick = {
            timerState.resetTimer()
        }) {
            Icon(painter = painterResource(id = R.drawable.ic_stop), contentDescription = "stop button")
        }
        ButtonLayout(timerState)
    }
}
@Composable
fun ButtonLayout(timerState: TimerViewModel) {
    val toggle by timerState.viewState.observeAsState()
    var text = ""
    var color: Color = MaterialTheme.colorScheme.primary
    var textColor: Color = Color.White
    when (toggle?.toggle) {
        ButtonState.START -> {
            text = "Start"
            color = MaterialTheme.colorScheme.primary
            textColor = Color.White
        }

        ButtonState.RESUME -> {
            text = "Resume"
            color = MaterialTheme.colorScheme.secondary
            textColor = Color.Black
        }

        ButtonState.PAUSE -> {
            text = "Pause"
            color = MaterialTheme.colorScheme.secondary
            textColor = Color.Black
        }

        else -> {}
    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Box(
            modifier = Modifier
                .clickable {
                    timerState.resetTimer()
                }
                .padding(30.dp)
                .size(80.dp)
                .clip(CircleShape)
                .background(Color.DarkGray)
                .fillMaxWidth())
        {
            Text(
                text = "Reset", color = Color.White, modifier = Modifier
                    .align(Alignment.Center)
                    .padding(8.dp)
            )
        }
        Box(modifier = Modifier
            .clickable {
                timerState.buttonselection()
            }
            .padding(10.dp)
            .size(80.dp)
            .clip(CircleShape)
            .background(color)
            .fillMaxWidth()) {
            Text(
                text = text, color = textColor, modifier = Modifier
                    .align(Alignment.Center)
                    .padding(8.dp)
            )
        }
    }
}
@Preview
@Composable
fun Previewtimer()
{
    TimerHomeScreen(viewModel = TimerViewModel())
}
