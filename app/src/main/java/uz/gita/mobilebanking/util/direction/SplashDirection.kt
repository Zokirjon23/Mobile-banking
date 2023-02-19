package uz.gita.mobilebanking.util.direction

import uz.sonia1.mmecompose.navigation.AppScreen

interface SplashDirection{

    suspend fun openLogin(screen: AppScreen)
    suspend fun openDashboard(screen: AppScreen)
}