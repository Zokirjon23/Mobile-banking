package uz.gita.mobilebanking.domain.repository.impl

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.mobilebanking.R
import uz.gita.mobilebanking.data.local.LocalStorage
import uz.gita.mobilebanking.data.model.ResultData
import uz.gita.mobilebanking.data.model.request.SignInRequest
import uz.gita.mobilebanking.data.model.response.SignInResponse
import uz.gita.mobilebanking.data.remote.AuthApi
import uz.gita.mobilebanking.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val authApi: AuthApi,private val localStorage: LocalStorage) : AuthRepository {
   override fun login(phone : String,password : String) = flow {
      emit(ResultData.Loading(true))
      val response = authApi.login(SignInRequest(phone,password))
      if (response.isSuccessful && response.body() != null){
         localStorage.token = response.body()!!.token.token
         emit(ResultData.Success(Unit))
      }else if (response.isSuccessful && response.body() == null){
         emit(ResultData.Message(errorMessage = response.body()!!.message.message))
      }else{
         emit(ResultData.Message(resId = R.string.server_connect_error))
      }
      emit(ResultData.Loading(false))
   }.catch {
      emit(ResultData.Error(it))
      emit(ResultData.Loading(false))
   }.flowOn(Dispatchers.IO)
}