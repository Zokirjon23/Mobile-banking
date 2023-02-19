package uz.gita.mobilebanking.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.mobilebanking.domain.repository.AuthRepository
import uz.gita.mobilebanking.domain.repository.impl.AuthRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindAuth(impl : AuthRepositoryImpl) : AuthRepository
}