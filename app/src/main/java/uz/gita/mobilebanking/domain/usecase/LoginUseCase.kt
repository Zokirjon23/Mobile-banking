package uz.gita.mobilebanking.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.mobilebanking.data.model.ResultData
import uz.gita.mobilebanking.domain.repository.AuthRepository
import javax.inject.Inject

interface LoginUseCase {
    fun login(phone : String,password : String) : Flow<ResultData<Unit>>
}

class LoginUseCaseImpl @Inject constructor(private val authRepository: AuthRepository) :
    LoginUseCase {
    override fun login(phone: String, password: String): Flow<ResultData<Unit>> {
        return authRepository.login(phone,password)
    }
}