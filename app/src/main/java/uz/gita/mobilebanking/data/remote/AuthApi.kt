package uz.gita.mobilebanking.data.remote

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import uz.gita.mobilebanking.data.model.request.SignInRequest
import uz.gita.mobilebanking.data.model.request.SignUpRequest
import uz.gita.mobilebanking.data.model.response.signIn.SignInResponse
import uz.gita.mobilebanking.data.model.response.signUp.SignUpResponse

interface AuthApi {
    @POST("auth/sign-in")
    suspend fun login(@Body request : SignInRequest) : Response<SignInResponse>

    @POST("auth/sign-up")
    suspend fun signUp(@Body request: SignUpRequest) : Response<SignUpResponse>
}
