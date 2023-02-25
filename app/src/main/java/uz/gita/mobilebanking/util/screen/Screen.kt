package uz.gita.mobilebanking.util.screen

import uz.gita.mobilebanking.ui.screen.auth.login.LoginScreen
import uz.gita.mobilebanking.ui.screen.auth.SplashScreen
import uz.gita.mobilebanking.ui.screen.auth.recovery.SignUpScreen
import uz.gita.mobilebanking.ui.screen.dashboard.DashBoardScreen

interface Screen {

    fun splash() : SplashScreen
    fun login() : LoginScreen
    fun dashboard() : DashBoardScreen
    fun recoveryAccount() : SignUpScreen
}