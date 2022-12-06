package ir.amirhparhizgar.logintask.presentation

import androidx.annotation.StringRes
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.amirhparhizgar.logintask.R
import ir.amirhparhizgar.logintask.data.local.Repository
import javax.inject.Inject
import kotlin.random.Random

/**
 * Created by AmirHossein Parhizgar on 12/5/2022.
 */
@HiltViewModel
class EnterPhoneViewModel @Inject constructor(
    val stateHandle: SavedStateHandle,
    val repository: Repository,
) : ViewModel() {

    @StringRes
    fun getMessage(phone: String): Int? {
        if (phone.isBlank())
            return R.string.phone_blank
        if (!isPhoneValid(phone))
            return R.string.phone_invalid
        return null
    }

    fun isPhoneValid(phone: String): Boolean {
        phone.toLongOrNull() ?: return false
        if (phone.length != 11)
            return false
        val prefix = phone.substring(0, 4).toInt()
        if (prefix < 911 || prefix > 918)
            return false
        return true
    }

    fun savePhone(phone: String) {
        repository.savePhone(phone)
        val otp = Random.nextInt(from = 0, until =  1_0000)
        println(otp)
        repository.saveOTP(otp)
    }
}