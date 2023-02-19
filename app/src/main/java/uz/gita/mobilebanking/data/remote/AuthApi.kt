package uz.gita.mobilebanking.data.remote

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import uz.gita.mobilebanking.data.model.request.SignInRequest
import uz.gita.mobilebanking.data.model.response.SignInResponse

interface AuthApi {
    @POST("auth/sign-up")
    suspend fun login(@Body request : SignInRequest) : Response<SignInResponse>
}
