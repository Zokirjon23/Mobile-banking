package uz.gita.mobilebanking.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import uz.gita.mobilebanking.ui.screen.auth.SplashScreen
import uz.gita.mobilebanking.ui.theme.MobileBankingTheme
import uz.sonia1.mmecompose.navigation.NavigationDispatcher
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationDispatcher: NavigationDispatcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileBankingTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigator(SplashScreen()){ nav ->
                        LaunchedEffect(key1 = nav) {
                            navigationDispatcher.dispatcher
                                .onEach {
                                    it.invoke(nav)
                                }.collect()
                        }
                        CurrentScreen()
                    }
                }
            }
        }
    }
}