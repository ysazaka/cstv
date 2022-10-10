package com.ysazaka.cstv.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import java.text.SimpleDateFormat
import java.util.*

abstract class BaseActivity : AppCompatActivity() {

    protected var bundle: Bundle? = null

    private val locale: Locale = Locale.getDefault()
    private val simpleDateFormat = SimpleDateFormat(CURRENT_DAY_FORMAT, locale)
    val currentDay = simpleDateFormat.format(Date())

    protected abstract fun getBinding(): View
    protected abstract fun initView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bundle = intent.extras

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        setContentView(getBinding())

        initView()
    }

    companion object {
        private const val CURRENT_DAY_FORMAT = "yyyy-MM-dd"
    }

}