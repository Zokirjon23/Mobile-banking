package uz.gita.mobilebanking.data.model.response

import com.google.gson.annotations.SerializedName

data class SignInResponse(
   @SerializedName("token") val token : SingInSuccess,
   @SerializedName("message") val message : SignInError
)
