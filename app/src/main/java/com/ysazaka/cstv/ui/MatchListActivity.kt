package com.ysazaka.cstv.ui

import android.view.View
import com.ysazaka.cstv.base.BaseActivity
import com.ysazaka.cstv.databinding.ActivityMatchListBinding

class MatchListActivity : BaseActivity() {

    private var _binding: ActivityMatchListBinding? = null
    private val binding get() = _binding!!

    override fun getBinding(): View {
        _binding = ActivityMatchListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun initView() {

    }

}