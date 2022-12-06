package ir.amirhparhizgar.logintask.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by AmirHossein Parhizgar on 12/5/2022.
 */
@HiltViewModel
class EnterOTPViewModel @Inject constructor(
    val stateHandle: SavedStateHandle
) : ViewModel() {
    companion object {
        private const val OTP_RESEND_DURATION: Long = 30_000L
    }

    private var otpSentTime: Long = System.currentTimeMillis()

    private val _timeToSendAgain = MutableStateFlow<Int>(30)
    val timeToSendAgain: StateFlow<Int> = _timeToSendAgain

    init {
        startEmittingRemainingTime()
        sendOTP()
    }

    private fun sendOTP() {
        // TODO send OTP
    }

    fun onResendClicked() {
        if (timeToSendAgain.value > 0)
            return
        otpSentTime = System.currentTimeMillis()
        viewModelScope.launch {
            _timeToSendAgain.emit(OTP_RESEND_DURATION.toInt() / 1000)
        }
        sendOTP()
    }

    private fun startEmittingRemainingTime() {
        viewModelScope.launch {
            while (true) { // it will exit when viewModelScope finishes
                val timeBeforeNextSend =
                    (otpSentTime - System.currentTimeMillis() + OTP_RESEND_DURATION).toInt() / 1000
                _timeToSendAgain.emit(timeBeforeNextSend.coerceAtLeast(0))
                delay(1_000)
            }
        }
    }
}