package uz.gita.mobilebanking.presenter.impl

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import uz.gita.mobilebanking.data.model.ResultData
import uz.gita.mobilebanking.domain.usecase.LoginUseCase
import uz.gita.mobilebanking.presenter.LoginViewModel
import uz.gita.mobilebanking.ui.screen.auth.login.LoginContract
import uz.gita.mobilebanking.util.direction.LoginDirection
import uz.gita.mobilebanking.util.screen.Screen
import javax.inject.Inject

@HiltViewModel
class LoginViewModelImpl @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val direction: LoginDirection,
    private val screen: Screen
) : ViewModel(), LoginViewModel {

    override val uiStateFlow = MutableStateFlow(LoginContract.UiState(false))

    override fun onEventDispatch(intent: LoginContract.Intent) {
        when (intent) {
            is LoginContract.Intent.Login -> {
                loginUseCase.login(intent.phone, intent.password).onEach {
                    when (it) {
                        is ResultData.Success -> direction.openDashBoard(screen.dashboard())
                        is ResultData.Loading -> {
                            Log.d("FFFF", "onEventDispatch: ${it.isLoading}")
                            uiStateFlow.value = LoginContract.UiState(it.isLoading)
                        }
                        is ResultData.Message -> {
                            Log.d("FFFF", "onEventDispatch: ${it.errorMessage}")
                            Log.d("FFFF", "onEventDispatch: ${it.resId}")
                            uiStateFlow.value = LoginContract.UiState(message = it.errorMessage)
                        }
                        is ResultData.Error -> {
                            Log.d("FFFF", "onEventDispatch: ${it.throwable.message}")
                            uiStateFlow.value = LoginContract.UiState(error = it.throwable.message)
                        }
                    }
                }.launchIn(viewModelScope)
            }
            is LoginContract.Intent.ForgotPassword -> {
                viewModelScope.launch {
                    direction.openRecovery(screen.recoveryAccount())
                }
            }
        }
    }

}
