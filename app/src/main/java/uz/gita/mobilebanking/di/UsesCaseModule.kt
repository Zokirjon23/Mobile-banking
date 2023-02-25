package uz.gita.mobilebanking.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.gita.mobilebanking.domain.usecase.LoginUseCase
import uz.gita.mobilebanking.domain.usecase.LoginUseCaseImpl
import uz.gita.mobilebanking.domain.usecase.SignUpUseCase
import uz.gita.mobilebanking.domain.usecase.impl.SignUpUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
interface UsesCaseModule {

    @Binds
    fun bindLogin(impl : LoginUseCaseImpl) : LoginUseCase
    @Binds
    fun bindSignUp(impl : SignUpUseCaseImpl) : SignUpUseCase

}