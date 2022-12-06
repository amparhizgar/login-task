package ir.amirhparhizgar.logintask.data.local

class Repository {
    private var phone: String? = null
    private var oTP: Int? = null

    fun savePhone(phone: String) {
        this.phone = phone
    }

    fun getPhoneAndOTPOrThrow() : UserAuth =
        UserAuth(phone!!, oTP!!)

    fun saveOTP(oTP: Int) {
        this.oTP = oTP
    }
}