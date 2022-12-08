package ir.amirhparhizgar.logintask.data.local

/**
 * Created by AmirHossein Parhizgar on 12/6/2022.
 */
interface Repository {

    fun savePhone(phone: String)

    fun getPhoneAndOTPOrThrow() : UserAuth
    fun saveOTP(oTP: Int)
}