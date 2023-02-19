package uz.gita.mobilebanking.util.direction.impl

import uz.gita.mobilebanking.util.direction.LoginDirection
import uz.sonia1.mmecompose.navigation.AppScreen
import uz.sonia1.mmecompose.navigation.Navigator
import javax.inject.Inject

class LoginDirectionImpl @Inject constructor(private val navigator: Navigator) : LoginDirection{

   override suspend fun openDashBoard(screen : AppScreen){
       navigator.navigateTo(screen)
   }

    override suspend fun openRecovery(screen: AppScreen) {
        navigator.navigateTo(screen)
    }
}