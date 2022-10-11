package com.ysazaka.cstv.ui

import android.content.Intent
import android.view.View
import com.ysazaka.cstv.base.BaseActivity
import com.ysazaka.cstv.data.model.match.MatchDto
import com.ysazaka.cstv.databinding.ActivityMatchListBinding
import com.ysazaka.cstv.ui.MatchDetailActivity.Companion.EXTRA_MATCH_DETAIL
import com.ysazaka.cstv.ui.adapter.MatchListAdapter
import com.ysazaka.cstv.viewmodel.GetListOfMatchesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MatchListActivity : BaseActivity(), MatchListener {

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
            getListOfMatchesViewModel.getListOfMatchesOfTheDay(currentDay.toString())
        }
    }

    private fun initObservers() {
        getListOfMatchesViewModel.loadingState.observe(::getLifecycle, ::setLoading)
        getListOfMatchesViewModel.matchesSuccessState.observe(::getLifecycle, ::setMatchList)
    }

    private fun setLoading(statusLoading: Boolean) {
        loading.visibility = if (statusLoading) View.VISIBLE else View.GONE
    }

    private fun setMatchList(list: List<MatchDto>) {
        currentMatchList = list
        binding.rvMatchList.apply {
            adapter = MatchListAdapter(currentMatchList, this@MatchListActivity, context)
        }
    }

    override fun onMatchClicked(matchDto: MatchDto) {
        val intent = Intent(this, MatchDetailActivity::class.java)
        intent.putExtra(EXTRA_MATCH_DETAIL, matchDto)
        startActivity(intent)
    }

}