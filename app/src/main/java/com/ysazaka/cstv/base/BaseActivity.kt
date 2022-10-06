package com.ysazaka.cstv.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

abstract class BaseActivity : AppCompatActivity() {

    protected var bundle: Bundle? = null

    protected abstract fun getBinding(): View
    protected abstract fun initView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bundle = intent.extras

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        setContentView(getBinding())

        initView()
    }

}