package uz.sonia1.mmecompose.navigation

import cafe.adriel.voyager.androidx.AndroidScreen

interface Navigator {
    suspend fun back()
    suspend fun navigateTo(screen: AppScreen)
    suspend fun replace(screen: AppScreen)
}

typealias AppScreen = AndroidScreen