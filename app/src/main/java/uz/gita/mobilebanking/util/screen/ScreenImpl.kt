package uz.gita.mobilebanking.util.screen

import uz.gita.mobilebanking.ui.screen.auth.login.LoginScreen
import uz.gita.mobilebanking.ui.screen.auth.SplashScreen
import uz.gita.mobilebanking.ui.screen.auth.recovery.SignUpScreen
import uz.gita.mobilebanking.ui.screen.dashboard.DashBoardScreen
import javax.inject.Inject

class ScreenImpl @Inject constructor() : Screen {

    override fun splash() = SplashScreen()
    override fun login() = LoginScreen()
    override fun dashboard() = DashBoardScreen()
    override fun recoveryAccount() = SignUpScreen()
}