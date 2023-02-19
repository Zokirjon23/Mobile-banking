package uz.gita.mobilebanking.util.direction

import uz.sonia1.mmecompose.navigation.AppScreen

interface LoginDirection {

    suspend fun openDashBoard(screen: AppScreen)
    suspend fun openRecovery(screen: AppScreen)
}