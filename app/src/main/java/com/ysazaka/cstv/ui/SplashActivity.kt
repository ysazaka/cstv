package com.ysazaka.cstv.ui

import android.content.Intent
import android.view.View
import com.ysazaka.cstv.base.BaseActivity
import com.ysazaka.cstv.databinding.ActivitySplashBinding
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivity : BaseActivity() {

    private var _binding: ActivitySplashBinding? = null
    private val binding get() = _binding!!

    override fun getBinding(): View {
        _binding = ActivitySplashBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun initView() {
        Timer().schedule(timerTask {
            startMainActivity()
        }, SPLASH_DURATION_TIME)
    }

    private fun startMainActivity() {
        startActivity(Intent(this, MatchListActivity::class.java))
        finish()
    }

    companion object {
        private const val SPLASH_DURATION_TIME = 2500L
    }

}