package com.example.madteamb.ui.theme


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.madteamb.model.TimerViewModel
import com.example.madteamb.ui.theme.ext.ButtonLayout
import com.example.madteamb.ui.theme.ext.TimerHomeScreen
import java.lang.Math.atan2
import java.lang.Math.cos
import java.lang.Math.sin
import kotlin.math.abs
import kotlin.math.atan2
@OptIn(ExperimentalTextApi::class)
@Composable
fun Content() {

    var radius by remember {
        mutableStateOf(0f)
    }

    var shapeCenter by remember {
        mutableStateOf(Offset.Zero)
    }

    var handleCenter by remember {
        mutableStateOf(Offset.Zero)
    }

    var angle by remember {
        mutableStateOf(270.0)
    }
    var sweepangle by remember {
        mutableStateOf(0.0)
    }
    var canDragBackwards by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GreenBackGround)
    )
    {

        Spacer(modifier =Modifier.height(180.dp))
        Box(
            modifier = Modifier
                .background(GreenBackGround)
        )
        {
            val textMeasurer = rememberTextMeasurer()
            Canvas(
                modifier = Modifier
                    .aspectRatio(1f)
                    .pointerInput(Unit) {
                        detectDragGestures { change, dragAmount ->

                            handleCenter += dragAmount
                            angle = getRotationAngle(handleCenter, shapeCenter)
                            angle = angle.coerceIn(0.0,270.0)
                            sweepangle = getSweepAngle(angle)
                            change.consume()

                        }
                    }
                    .padding(60.dp)

            ) {
                shapeCenter = center
                radius = size.minDimension / 2

                val x = (shapeCenter.x + cos(Math.toRadians(angle)) * radius).toFloat()
                val y = (shapeCenter.y + sin(Math.toRadians(angle)) * radius).toFloat()

                handleCenter = Offset(x, y)
                drawCircle(color = GreenBackGround, radius = radius)
                drawCircle(color = GreenCircle, radius = radius, style = Stroke(20f))
                drawArc(
                    color = Color.White,
                    startAngle = -90f,
                    sweepAngle = sweepangle.toFloat(),
                    useCenter = false,
                    style = Stroke(20f)
                )

                drawCircle(color = Color.White, center = handleCenter, radius = 30f)
            }


        }
        Text(text = sweepangle.toString(),
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 70.sp,
            fontFamily = FontFamily.Default
            )
//        TimerHomeScreen(viewModel = TimerViewModel(AngleToTimeSession(sweepangle.toInt())*60))
//        ButtonLayout(timerState = TimerViewModel())
    }
}
private fun getRotationAngle(currentPosition: Offset, center: Offset): Double {
    val (dx, dy) = currentPosition - center
    val theta = atan2(dy, dx).toDouble()

    var angle = Math.toDegrees(theta)

    if (angle < 0) {
        angle += 360.0
    }
    return angle

}


private fun getSweepAngle(angle:Double): Double {
   var a = angle
    if (angle >=270)
    {
        a= a-270
        return a
    }
    else {return a+90}

}

private fun AngleToTimeSession(sweepAngle:Int): Long {
  var minutes :Long = sweepAngle/(3.toLong())+1
  if (minutes%5 !=0 .toLong())
  {
      return 0
  }

  return minutes
}
@Preview (
)
@Composable
fun previewContent()
{
    Content()
}


