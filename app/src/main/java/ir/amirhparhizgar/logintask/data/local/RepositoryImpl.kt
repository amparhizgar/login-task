package ir.amirhparhizgar.logintask.data.local

class RepositoryImpl: Repository {
    private var phone: String? = null
    private var oTP: Int? = null

    override fun savePhone(phone: String) {
        this.phone = phone
    }

    override fun getPhoneAndOTPOrThrow() : UserAuth =
        UserAuth(phone!!, oTP!!)

    override fun saveOTP(oTP: Int) {
        this.oTP = oTP
    }
}