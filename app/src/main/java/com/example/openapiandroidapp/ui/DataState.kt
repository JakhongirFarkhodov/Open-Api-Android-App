package com.example.openapiandroidapp.ui

data class DataState<T>(
    val loading: isLoading = isLoading(isLoading = false),
    val data: Data<T>? = null,
    val stateError:Event<Response>? = null
)
{
    companion object{
        fun <T> error(response: Response):DataState<T>
        {
            return DataState(stateError = Event(response))
        }

        fun <T> loading(isLoading: Boolean, cachedData:T?):DataState<T>
        {
            return DataState(loading = isLoading(isLoading), data = Data(data = Event.dataEvent(data = cachedData), response = null))
        }

        fun <T> data(data:T?, response: Response?):DataState<T>
        {
            return DataState(data = Data(data = Event.dataEvent(data), response = Event.responseEvent(response)))
        }
    }
}
