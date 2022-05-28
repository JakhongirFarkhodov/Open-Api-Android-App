package com.example.openapiandroidapp.ui

data class isLoading(val isLoading:Boolean)
data class Data<T>(val data:Event<T>?, val response:Event<Response>?)
data class StateError(val response:Response)

data class Response(val message:String, val responseType:ResponseType)

sealed class ResponseType{
    class Toast:ResponseType()
    class Dialog:ResponseType()
    class None:ResponseType()
}

class Event<T> constructor(private val content:T)
{
    private var hasBeenHandled:Boolean = false

    fun peekContent():T = content

    fun getContentIfNotHandled():T?
    {
        return if (hasBeenHandled)
        {
            null
        }
        else{
            hasBeenHandled = true
            content
        }
    }

    companion object{
        fun <T> dataEvent(data:T?):Event<T>?{

            data?.let {
                return Event(it)
            }
            return null
        }

        fun responseEvent(response:Response?):Event<Response>?
        {
            response?.let {
                return Event(it)
            }
            return null
        }
    }
}