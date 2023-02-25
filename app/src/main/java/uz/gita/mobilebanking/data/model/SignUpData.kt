package uz.gita.mobilebanking.data.model

import uz.gita.mobilebanking.data.model.request.SignUpRequest

data class SignUpData(
    val name: String,
    val lastName: String,
    val phone: String,
    val isMale: Boolean,
    val dateBirth : String,
    val password : String
)

fun SignUpData.toSignUpRequest() : SignUpRequest{
    return SignUpRequest(dateBirth,name,if (isMale) "0" else "1",lastName,password,phone)
}