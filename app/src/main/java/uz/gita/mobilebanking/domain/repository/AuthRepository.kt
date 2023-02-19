package uz.gita.mobilebanking.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.mobilebanking.data.model.ResultData
import uz.gita.mobilebanking.data.model.response.SignInResponse

interface AuthRepository{
    fun login(phone : String,password : String): Flow<ResultData<Unit>>
}