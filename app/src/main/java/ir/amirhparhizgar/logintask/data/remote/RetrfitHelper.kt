package ir.amirhparhizgar.logintask.data.remote

/**
 * Created by AmirHossein Parhizgar on 12/6/2022.
 */
import retrofit2.Retrofit

object RetrofitHelper {
    private const val baseUrl = "https://www.payam-resan.com"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .build()
    }
}