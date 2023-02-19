package uz.gita.mobilebanking.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.sonia1.mmecompose.navigation.NavigationDispatcher
import uz.sonia1.mmecompose.navigation.NavigationImpl
import uz.sonia1.mmecompose.navigation.Navigator

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @Binds
    fun bindNavigator(impl: NavigationImpl) : Navigator

    @Binds
    fun bindDispatcher(impl: NavigationImpl) : NavigationDispatcher
}