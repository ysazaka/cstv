package com.ysazaka.cstv.ui

import android.util.Log
import android.view.View
import com.ysazaka.cstv.base.BaseActivity
import com.ysazaka.cstv.data.model.match.MatchDto
import com.ysazaka.cstv.databinding.ActivityMatchListBinding
import com.ysazaka.cstv.viewmodel.GetListOfMatchesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MatchListActivity : BaseActivity() {

    private var _binding: ActivityMatchListBinding? = null
    private val binding get() = _binding!!

    private var currentMatchList: List<MatchDto> = listOf()
    private val getListOfMatchesViewModel by viewModel<GetListOfMatchesViewModel>()

    override fun getBinding(): View {
        _binding = ActivityMatchListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun initView() {
        initObservers()
        if (currentMatchList.isEmpty()) {
            getListOfMatchesViewModel.getListOfMatchesOfTheDay()
        }
    }

    private fun initObservers() {
        getListOfMatchesViewModel.loadingState.observe(::getLifecycle, ::setLoading)
        getListOfMatchesViewModel.matchesSuccessState.observe(::getLifecycle, ::setMatchList)
    }

    private fun setLoading(statusLoading: Boolean) {
//        loading.visibility = if (statusLoading) View.VISIBLE else View.GONE
    }

    private fun setMatchList(list: List<MatchDto>) {
        currentMatchList = list
        Log.d("Test", "All right!")
    }

}