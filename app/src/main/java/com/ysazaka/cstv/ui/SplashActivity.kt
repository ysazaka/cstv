package com.ysazaka.cstv.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.ysazaka.cstv.R
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Timer().schedule(timerTask {
            startMatchesActivity()
        }, SPLASH_DURATION_TIME)
    }

    private fun startMatchesActivity() {
        startActivity(Intent(this, MatchesActivity::class.java))
        finish()
    }

    companion object {
        private const val SPLASH_DURATION_TIME = 2500L
    }

}