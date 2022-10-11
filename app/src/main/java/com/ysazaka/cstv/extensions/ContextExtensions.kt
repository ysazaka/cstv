package com.ysazaka.cstv.extensions

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.ysazaka.cstv.R

fun makeLoading(context: Context): View {
    return LayoutInflater.from(context).inflate(R.layout.view_loading, null, false)
}