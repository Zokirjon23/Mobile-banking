package uz.gita.mobilebanking.presenter.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.mobilebanking.data.model.ResultData
import uz.gita.mobilebanking.data.model.SignUpData
import uz.gita.mobilebanking.domain.usecase.SignUpUseCase
import uz.gita.mobilebanking.presenter.SignInViewModel
import uz.gita.mobilebanking.ui.screen.auth.recovery.SignUpContract
import javax.inject.Inject

@HiltViewModel
class SignInViewModelImpl @Inject constructor(private val signUpUseCase: SignUpUseCase) : ViewModel(), SignInViewModel {
    override val uiState = MutableStateFlow<SignUpContract.UIState>(SignUpContract.UIState(false,null,null))

    private fun reduce(block : SignUpContract.UIState.() -> SignUpContract.UIState){
        val oldValue = uiState.value
        uiState.value = block(oldValue)
    }
    override fun onEventDispatch(intent: SignUpContract.Intent) {
        when (intent) {
            is SignUpContract.Intent.CreateUser -> {
                reduce { copy(loading = true) }
                signUpUseCase.createUser(intent.signUpData).onEach {
                    reduce { copy(loading = false) }

                    when(it){
                        is ResultData.Success -> {}
                        is ResultData.Error -> reduce { copy(error = it.throwable.message.toString()) }
                        is ResultData.Message -> reduce { copy(error = it.errorMessage, errorResId = it.resId)  }
                    }
                }.launchIn(viewModelScope)
            }
        }
    }
}
