package uz.gita.mobilebanking.presenter.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.gita.mobilebanking.presenter.SplashViewModel
import uz.gita.mobilebanking.util.direction.SplashDirection
import uz.gita.mobilebanking.util.screen.Screen
import javax.inject.Inject

@HiltViewModel
class SplashViewModelImpl @Inject constructor(private val splashDirection: SplashDirection,screens: Screen) : SplashViewModel,ViewModel() {

    init {
        viewModelScope.launch {
            delay(1500)
            splashDirection.openLogin(screens.login())
        }
    }
}