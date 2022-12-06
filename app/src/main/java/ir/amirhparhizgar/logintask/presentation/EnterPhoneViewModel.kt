package ir.amirhparhizgar.logintask.presentation

import androidx.annotation.StringRes
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.amirhparhizgar.logintask.R
import javax.inject.Inject

/**
 * Created by AmirHossein Parhizgar on 12/5/2022.
 */
@HiltViewModel
class EnterPhoneViewModel @Inject constructor(
    val stateHandle: SavedStateHandle
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
        val trimmedPhone = phone.trim()
        trimmedPhone.toIntOrNull() ?: return false
        if (trimmedPhone.length != 11)
            return false
        val prefix = trimmedPhone.substring(0, 4).toInt()
        if (prefix < 911 || prefix > 918)
            return false
        return true
    }
}