package uz.gita.mobilebanking.presenter

import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import uz.gita.mobilebanking.ui.screen.auth.recovery.SignUpContract

interface SignInViewModel {

    val uiState : StateFlow<SignUpContract.UIState>

    fun onEventDispatch(intent: SignUpContract.Intent)
}
