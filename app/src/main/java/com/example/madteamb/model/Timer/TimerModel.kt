package com.example.madteamb.model.Timer
import java.time.Duration


data class TimerModel(
    var TimeSession:Long = 600,
    var timeDuration: Duration = Duration.ofSeconds(TimeSession),
    val remaingTime: Long = timeDuration.toMillis(),
    val status: Status = Status.STARTED,
    val toggle: ButtonState = ButtonState.START,
    val gold :Long = 0
)
enum class Status
{
    STARTED,FINSIHED,RUNNING
}
enum class ButtonState
{
    START,PAUSE,RESUME
}
