package uz.gita.mobilebanking.ui.screen.auth.login

class LoginContract{

sealed interface Intent{
    class Login(val phone : String,val password : String) : Intent
    object ForgotPassword : Intent
}

data class UiState(
    val isLoading : Boolean? = null,
    val message : String? = null,
    val error : String? = null,
)

}
