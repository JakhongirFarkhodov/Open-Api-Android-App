package com.example.openapiandroidapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<StateEvent, ViewState> : ViewModel() {

    private val _stateEvent: MutableLiveData<StateEvent> = MutableLiveData()
    private val _viewState: MutableLiveData<ViewState> = MutableLiveData()

    val viewState: LiveData<ViewState>
        get() = _viewState

    val dataState: LiveData<DataState<ViewState>> = Transformations.switchMap(_stateEvent)
    { stateEvent ->
        handleStateEvent(stateEvent)
    }

    fun getCurrentViewStateOrCreateNew():ViewState
    {
        val value = _viewState.value?.let {
            it
        }?:createNewViewState()
        return value
    }

    abstract fun createNewViewState(): ViewState

    abstract fun handleStateEvent(stateEvent: StateEvent): LiveData<DataState<ViewState>>


    fun setStateEvent(event: StateEvent)
    {
        _stateEvent.value = event!!
    }

}