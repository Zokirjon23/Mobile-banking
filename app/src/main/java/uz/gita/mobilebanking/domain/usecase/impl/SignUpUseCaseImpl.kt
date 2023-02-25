package uz.gita.mobilebanking.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.mobilebanking.data.model.ResultData
import uz.gita.mobilebanking.data.model.SignUpData
import uz.gita.mobilebanking.data.model.response.signUp.SignUpResponse
import uz.gita.mobilebanking.data.model.toSignUpRequest
import uz.gita.mobilebanking.domain.repository.AuthRepository
import uz.gita.mobilebanking.domain.usecase.SignUpUseCase
import javax.inject.Inject

class SignUpUseCaseImpl @Inject constructor(private val authRepository: AuthRepository) : SignUpUseCase {
    override fun createUser(signUpData: SignUpData): Flow<ResultData<Unit>> {
        return authRepository.createUser(signUpData.toSignUpRequest())
    }
}