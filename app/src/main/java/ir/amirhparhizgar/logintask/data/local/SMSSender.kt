package ir.amirhparhizgar.logintask.data.local

import ir.amirhparhizgar.logintask.BuildConfig
import ir.amirhparhizgar.logintask.data.remote.SMSApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by AmirHossein Parhizgar on 12/6/2022.
 */
class SMSSender @Inject constructor(
    private val smsApi: SMSApi
) {
    suspend fun sendOTP(oTP: String, phone: String) {
        withContext(Dispatchers.IO) {
            smsApi.sendSMS(
                BuildConfig.PAYAMRESAN_USERNAME, BuildConfig.PAYAMRESAN_PASSWORD, "-1",
                phone, "کد تایید شما: %s".format(oTP)
            )
        }
    }
}