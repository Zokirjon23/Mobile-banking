package uz.sonia1.mmecompose.navigation

import android.util.Log
import cafe.adriel.voyager.androidx.AndroidScreen
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigationImpl @Inject constructor() : Navigator,NavigationDispatcher{

    override val dispatcher =  MutableSharedFlow<NavigationApp>()

    private suspend fun navigation(args : NavigationApp) {
        dispatcher.emit(args)
    }

    override suspend fun navigateTo(screen : AppScreen) = navigation {
        push(screen)
    }

    override suspend fun back() = navigation {
        pop()
    }

    override suspend fun replace(screen: AppScreen) = navigation {
        replace(screen)
    }

}