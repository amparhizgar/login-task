package ir.amirhparhizgar.logintask.data.local

/**
 * Created by AmirHossein Parhizgar on 12/6/2022.
 */
interface RepositoryKK {
    fun savePhoneAndOTP(phone: String, OTP: Int)
    fun getPhone()
    fun getOTP()
}