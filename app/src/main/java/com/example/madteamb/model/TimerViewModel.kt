package com.example.madteamb.model

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.sql.Time
import java.time.Duration

class TimerViewModel(timeSession:Long):ViewModel() {
    private  val _viewState = MutableLiveData<TimerModel>()
    val viewState: LiveData<TimerModel> =_viewState
    var countdown: CountDownTimer ?= null
    var timeSesiw = timeSession
    init {
        _viewState.value = TimerModel(TimeSession = timeSession)
    }
    fun startTime(duration: Duration)
    {
        countdown = object: CountDownTimer(duration.toMillis(),10)
        {
            override fun onTick(seconds: Long) {
                _viewState.value = TimerModel(
                    timeDuration = Duration.ofMillis(seconds),
                    remaingTime =  seconds,
                    status = Status.RUNNING,
                    toggle= ButtonState.PAUSE
                )
            }

            override fun onFinish() {
                _viewState.value = _viewState.value!!.copy(
                    timeDuration = Duration.ZERO,
                    status = Status.FINSIHED,
                    toggle = ButtonState.START
                )
            }
        }
        countdown?.start()
    }

    fun resetTimer()
    {
        countdown?.cancel()
        _viewState.value =_viewState.value!!.copy(
            status = Status.STARTED,
            timeDuration = Duration.ofSeconds(timeSesiw),
            toggle = ButtonState.START
        )
    }

    fun buttonselection()
    {
        var state = _viewState.value
        when (state?.status)
        {
            Status.STARTED ->{
                startTime(state.timeDuration)
            }
            Status.FINSIHED ->{
                resetTimer()
            }

            else -> {}
        }
    }

}