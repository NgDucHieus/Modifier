package com.example.madteamb.model
import java.time.Duration

data class TimerModel(
    val timeDuration: Duration = Duration.ofSeconds(30),
    val remaingTime: Long = timeDuration.toMillis(),
    val status: Status = Status.STARTED,
    val toggle:ButtonState = ButtonState.START
)
enum class Status
{
    STARTED,FINSIHED,RUNNING
}
enum class ButtonState
{
    START,PAUSE,RESUME
}
