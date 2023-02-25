package uz.gita.mobilebanking.data.model.response.signUp

data class SignUpResponse(
    val success: SignUpSuccess,
    val error: SignUpError
)