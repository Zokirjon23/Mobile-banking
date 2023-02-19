package uz.gita.mobilebanking.di

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody
import okhttp3.internal.http2.ConnectionShutdownException
import uz.gita.mobilebanking.data.local.LocalStorage
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthorizationInterceptor @Inject constructor(
    private val localStorage: LocalStorage
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        try {
            Log.d("token","token : ${localStorage.token}")
            val request = chain.request()
            val response = request.newBuilder().addHeader(
                "Authorization", "${localStorage.token}"
            ).build()
            return chain.proceed(response)
        } catch (e: Exception) {
            val msg = when (e) {
                is SocketTimeoutException -> {
                    "Timeout - Please check your internet connection"
                }
                is UnknownHostException -> {
                    "Unable to make a connection. Please check your internet"
                }
                is ConnectionShutdownException -> {
                    "Connection shutdown. Please check your internet"
                }
                is IOException -> {
                    "Server is unreachable, please try again later."
                }
                is IllegalStateException -> {
                    "${e.message}"
                }
                else -> {
                    "${e.message}"
                }
            }
            return Response.Builder()
                .request(chain.request())
                .protocol(Protocol.HTTP_1_1)
                .code(999)
                .message(msg)
                .body(ResponseBody.create(null, "{${e}}")).build()
        }
    }
}