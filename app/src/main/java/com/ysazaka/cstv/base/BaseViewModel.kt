package com.ysazaka.cstv.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext

open class BaseViewModel : ViewModel(), CoroutineScope {

    protected var _onError: MutableLiveData<Throwable> = MutableLiveData()
    val onError: LiveData<Throwable>
        get() = _onError

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + SupervisorJob()

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancel()
    }
}