package uz.gita.mobilebanking.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.mobilebanking.data.model.ResultData
import uz.gita.mobilebanking.data.model.SignUpData
import uz.gita.mobilebanking.data.model.response.signUp.SignUpResponse

interface SignUpUseCase {
    fun createUser(signUpData: SignUpData) : Flow<ResultData<Unit>>
}