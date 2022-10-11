package com.ysazaka.cstv.ui

import com.ysazaka.cstv.data.model.match.MatchDto

interface MatchListener {
    fun onMatchClicked(matchDto: MatchDto)
}