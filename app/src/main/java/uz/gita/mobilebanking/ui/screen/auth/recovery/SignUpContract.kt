package uz.gita.mobilebanking.ui.screen.auth.recovery

import uz.gita.mobilebanking.data.model.SignUpData

class SignUpContract {

    data class UIState(
        val loading: Boolean,
        val error: String?,
        val errorResId: Int?
    )

    sealed interface Intent {
        class CreateUser(val signUpData: SignUpData) : Intent
    }
}