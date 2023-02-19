package uz.gita.mobilebanking.util.direction.impl

import uz.gita.mobilebanking.util.direction.SplashDirection
import uz.sonia1.mmecompose.navigation.AppScreen
import uz.sonia1.mmecompose.navigation.Navigator
import javax.inject.Inject

class SplashDirectionImpl @Inject constructor(private val navigator: Navigator) : SplashDirection{

   override suspend fun openLogin(screen: AppScreen){
       navigator.replace(screen)
   }
   override suspend fun openDashboard(screen: AppScreen){
       navigator.replace(screen)
   }
}