package com.ysazaka.cstv.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ysazaka.cstv.base.BaseViewModel
import com.ysazaka.cstv.data.model.match.PlayerDto
import com.ysazaka.cstv.data.model.response.ResponseRequired
import com.ysazaka.cstv.usecase.GetListOfPlayersOfATeamUseCase
import kotlinx.coroutines.launch

class GetListOfPlayersOfATeamViewModel(
    private val getListOfPlayersOfATeamUseCase: GetListOfPlayersOfATeamUseCase
) : BaseViewModel() {

    private var _loadingState: MutableLiveData<Boolean> = MutableLiveData()
    val loadingState: LiveData<Boolean>
        get() = _loadingState

    private var _teamOnePlayersSuccessState: MutableLiveData<List<PlayerDto>> = MutableLiveData()
    val teamOnePlayersSuccessState: LiveData<List<PlayerDto>>
        get() = _teamOnePlayersSuccessState

    private var _teamTwoPlayersSuccessState: MutableLiveData<List<PlayerDto>> = MutableLiveData()
    val teamTwoPlayersSuccessState: LiveData<List<PlayerDto>>
        get() = _teamTwoPlayersSuccessState

    private var _playersErrorState: MutableLiveData<Throwable> = MutableLiveData()
    val playersErrorState: LiveData<Throwable>
        get() = _playersErrorState


    fun getListOfPlayersOfTeamOne(teamId: Long) {
        viewModelScope.launch {
            _loadingState.postValue(true)
            when (val response = getListOfPlayersOfATeamUseCase.invoke(teamId)) {
                is ResponseRequired.Success -> {
                    _teamOnePlayersSuccessState.postValue(response.result)
                }
                is ResponseRequired.Error -> {
                    _playersErrorState.postValue(response.throwable)
                }
            }
            _loadingState.postValue(false)
        }
    }

    fun getListOfPlayersOfTeamTwo(teamId: Long) {
        viewModelScope.launch {
            _loadingState.postValue(true)
            when (val response = getListOfPlayersOfATeamUseCase.invoke(teamId)) {
                is ResponseRequired.Success -> {
                    _teamTwoPlayersSuccessState.postValue(response.result)
                }
                is ResponseRequired.Error -> {
                    _playersErrorState.postValue(response.throwable)
                }
            }
            _loadingState.postValue(false)
        }
    }

}