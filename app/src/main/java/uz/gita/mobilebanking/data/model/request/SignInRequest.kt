package uz.gita.mobilebanking.data.model.request

import com.google.gson.annotations.SerializedName

data class SignInRequest(
   @SerializedName("password") val password: String,
   @SerializedName("phone") val phone: String
)