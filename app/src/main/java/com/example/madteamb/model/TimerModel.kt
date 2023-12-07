package com.example.madteamb.model
import java.time.Duration
import androidx.compose.runtime.remember


data class TimerModel(
    var TimeSession:Long = 30,
    val timeDuration: Duration = Duration.ofSeconds(TimeSession),
    val remaingTime: Long = timeDuration.toMillis(),
    val status: Status = Status.STARTED,
    val toggle:ButtonState = ButtonState.START,
)
enum class Status
{
    STARTED,FINSIHED,RUNNING
}
enum class ButtonState
{
    START,PAUSE,RESUME
}
