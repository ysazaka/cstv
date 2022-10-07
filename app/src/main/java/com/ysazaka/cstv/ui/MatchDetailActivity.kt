package com.ysazaka.cstv.ui

import android.view.View
import com.ysazaka.cstv.base.BaseActivity
import com.ysazaka.cstv.databinding.ActivityMatchDetailBinding

class MatchDetailActivity : BaseActivity() {

    private var _binding: ActivityMatchDetailBinding? = null
    private val binding get() = _binding!!

    override fun getBinding(): View {
        _binding = ActivityMatchDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun initView() {

    }

}