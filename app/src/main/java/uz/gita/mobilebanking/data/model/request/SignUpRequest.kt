package uz.gita.mobilebanking.data.model.request

import com.google.gson.annotations.SerializedName
import uz.gita.mobilebanking.data.model.SignUpData

data class SignUpRequest(
   @SerializedName("born-date") val bornDate: String,
   @SerializedName("first-name") val firstName: String,
   @SerializedName("gender") val gender: String,
   @SerializedName("last-name")  val lastName: String,
   @SerializedName("password")  val password: String,
   @SerializedName("phone")  val phone: String
)

fun SignUpRequest.toSignUpData() : SignUpData {
    return SignUpData(firstName,lastName,phone,gender == "0",bornDate,password)
}