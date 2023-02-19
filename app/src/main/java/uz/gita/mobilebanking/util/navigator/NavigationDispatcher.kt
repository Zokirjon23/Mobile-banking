package uz.sonia1.mmecompose.navigation

import cafe.adriel.voyager.navigator.Navigator
import kotlinx.coroutines.flow.SharedFlow

interface NavigationDispatcher {
    val dispatcher : SharedFlow<NavigationApp>
}

typealias NavigationApp = Navigator.() -> Unit