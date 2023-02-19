package uz.gita.mobilebanking.presenter

import kotlinx.coroutines.flow.StateFlow
import uz.gita.mobilebanking.ui.screen.auth.login.LoginContract

interface LoginViewModel {
    val uiStateFlow : StateFlow<LoginContract.UiState>

    fun onEventDispatch(intent: LoginContract.Intent)
}
