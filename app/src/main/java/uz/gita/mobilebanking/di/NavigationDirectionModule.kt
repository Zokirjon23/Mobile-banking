package uz.gita.mobilebanking.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.mobilebanking.util.direction.LoginDirection
import uz.gita.mobilebanking.util.direction.SplashDirection
import uz.gita.mobilebanking.util.direction.impl.LoginDirectionImpl
import uz.gita.mobilebanking.util.direction.impl.SplashDirectionImpl

@Module
@InstallIn(SingletonComponent::class)
interface NavigationDirectionModule {

    @Binds
    fun bindSplash(impl: SplashDirectionImpl) : SplashDirection

    @Binds
    fun bindLogin(impl: LoginDirectionImpl) : LoginDirection
}