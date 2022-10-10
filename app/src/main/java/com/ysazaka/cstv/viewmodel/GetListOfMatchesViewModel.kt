package com.ysazaka.cstv.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ysazaka.cstv.base.BaseViewModel
import com.ysazaka.cstv.data.model.match.MatchDto
import com.ysazaka.cstv.data.model.response.ResponseRequired
import com.ysazaka.cstv.usecase.GetListOfMatchesUseCase
import kotlinx.coroutines.launch

class GetListOfMatchesViewModel(
    private val getListOfMatchesUseCase: GetListOfMatchesUseCase
) : BaseViewModel() {

    private var _loadingState: MutableLiveData<Boolean> = MutableLiveData()
    val loadingState: LiveData<Boolean>
        get() = _loadingState

    private var _matchesSuccessState: MutableLiveData<List<MatchDto>> = MutableLiveData()
    val matchesSuccessState: LiveData<List<MatchDto>>
        get() = _matchesSuccessState

    private var _matchesErrorState: MutableLiveData<Throwable> = MutableLiveData()
    val matchesErrorState: LiveData<Throwable>
        get() = _matchesErrorState


    fun getListOfMatchesOfTheDay(dayFilter: String) {
        viewModelScope.launch {
            _loadingState.postValue(true)
            when (val response = getListOfMatchesUseCase.invoke(dayFilter)) {
                is ResponseRequired.Success -> {
                    _matchesSuccessState.postValue(response.result)
                }
                is ResponseRequired.Error -> {
                    _matchesErrorState.postValue(response.throwable)
                }
            }
            _loadingState.postValue(false)
        }
    }

}