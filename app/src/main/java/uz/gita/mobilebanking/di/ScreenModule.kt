package uz.gita.mobilebanking.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.mobilebanking.util.screen.Screen
import uz.gita.mobilebanking.util.screen.ScreenImpl

@Module
@InstallIn(SingletonComponent::class)
interface ScreenModule {

    @Binds
    fun bindScreens(impl : ScreenImpl) : Screen
}