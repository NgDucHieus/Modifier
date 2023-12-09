package com.example.madteamb.ui.theme.ext

import android.view.MotionEvent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.madteamb.model.TimerViewModel
import com.example.madteamb.ui.theme.GreenBackGround
import com.example.madteamb.ui.theme.GreenCircle
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.atan2
import kotlin.math.min

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MuneerCircularProgressBar(
    modifier: Modifier = Modifier,
    padding: Float = 150f,
    stroke: Float = 35f,
    cap: StrokeCap = StrokeCap.Round,
    initialAngle : Double = 0.0,
    onProgressChanged: (progress: Double) -> Unit,
) {
    var width by remember { mutableStateOf(0) }
    var height by remember { mutableStateOf(0) }
    var radius by remember { mutableStateOf(0f) }
    var center by remember { mutableStateOf(Offset.Zero) }

    var appliedAngle by remember {
        mutableStateOf(initialAngle)
    }
    var lastAngle by remember {
        mutableStateOf(0.0)
    }


            Canvas(modifier = modifier
                .aspectRatio(1f)
                .onGloballyPositioned {
                    width = it.size.width
                    height = it.size.height
                    center = Offset(width / 2f, height / 2f)
                    radius = min(width.toFloat(), height.toFloat()) / 2f - padding - stroke / 2f
                }
                .pointerInteropFilter {

                    when (it.action) {
                        MotionEvent.ACTION_DOWN -> {

                        }

                        MotionEvent.ACTION_MOVE -> {
                            appliedAngle = if (center.x > it.x && center.y > it.y) {
                                270 + deltaAngle(center.x - it.x, center.y - it.y)
                            } else {
                                90 - deltaAngle(it.x - center.x, center.y - it.y)
                            }

                            val diff = abs(lastAngle - appliedAngle)
                            if (diff > 180) {
                                appliedAngle = if (appliedAngle < 180) {
                                    360.0
                                } else {
                                    0.0
                                }
                            }

                            onProgressChanged(appliedAngle / 360.0)
                            lastAngle = appliedAngle

                        }

                        MotionEvent.ACTION_UP -> {

                        }

                        else -> return@pointerInteropFilter false
                    }

                    return@pointerInteropFilter true
                }
            )
            {
                drawArc(
                    color = GreenCircle,
                    startAngle = -90f,
                    sweepAngle = 360f,
                    useCenter = false,
                    topLeft = center - Offset(radius, radius),
                    size = Size(radius * 2, radius * 2),
                    style = Stroke(
                        width = stroke,
                        cap = cap
                    )
                )


                drawArc(
                    color = Color.White,
                    startAngle = -90f,
                    sweepAngle = abs(appliedAngle.toFloat()),
                    topLeft = center - Offset(radius, radius),
                    size = Size(radius * 2, radius * 2),
                    useCenter = false,
                    style = Stroke(
                        width = stroke,
                        cap = cap
                    )
                )
                drawCircle(
                    color = Color.White,
                    radius = stroke,
                    center = center + Offset(
                        radius * kotlin.math.cos((-90 + abs(appliedAngle)) * PI / 180f).toFloat(),
                        radius * kotlin.math.sin((-90 + abs(appliedAngle)) * PI / 180f).toFloat()
                    )
                )

            }
        }


fun deltaAngle(x: Float, y: Float): Double {
    return Math.toDegrees(atan2(y.toDouble(), x.toDouble()))
}
@Preview
@Composable
fun PreviewDrag() {

        MuneerCircularProgressBar(onProgressChanged = {})
}