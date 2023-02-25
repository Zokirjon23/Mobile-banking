package uz.gita.mobilebanking.data.model

sealed class ResultData<out T> {
    class Success<T>(val t: T) : ResultData<T>()
    class Error<T>(val throwable: Throwable) : ResultData<T>()
    class Message<T>(val errorMessage: String? = null, val resId: Int = 0) : ResultData<T>()
}