package ir.amirhparhizgar.logintask.data.remote

/**
 * Created by AmirHossein Parhizgar on 12/6/2022.
 */

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SMSApi {
    @GET("/APISend.aspx")
    suspend fun sendSMS(
        @Query("Username") username: String,
        @Query("Password") password: String,
        @Query("From") from: String,
        @Query("To") to: String,
        @Query("Text") text: String,
    ): Response<ResponseBody>
}