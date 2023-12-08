package com.example.madteamb.model

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.Duration

class TimerViewModel:ViewModel() {
    private  val _viewState = MutableLiveData<TimerModel>()
    val viewState: LiveData<TimerModel> =_viewState
    var countdown: CountDownTimer ?= null

    init {
        _viewState.value = TimerModel()
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
    private fun pauseTimer()
    {
        countdown?.cancel()
        _viewState.value = _viewState.value!!.copy(
            status = Status.STARTED,
            toggle = ButtonState.RESUME
        )
    }
    fun resetTimer(timeSessionw:Long = 600)
    {
        countdown?.cancel()
        _viewState.value =_viewState.value!!.copy(
            status = Status.STARTED,
            timeDuration = Duration.ofSeconds(timeSessionw),
            toggle = ButtonState.START
        )
    }

    fun buttonselection(timeSessionw: Long =2000)
    {
        val state = _viewState.value
        when (state?.status)
        {
            Status.STARTED ->{
                startTime(state.timeDuration)
            }
            Status.RUNNING ->{
                pauseTimer()
            }
            Status.FINSIHED ->{
                resetTimer()
            }

            else -> {}
        }
    }

}