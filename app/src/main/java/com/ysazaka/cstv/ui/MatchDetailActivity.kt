package com.ysazaka.cstv.ui

import android.view.View
import com.bumptech.glide.Glide
import com.ysazaka.cstv.R
import com.ysazaka.cstv.base.BaseActivity
import com.ysazaka.cstv.data.model.match.MatchDto
import com.ysazaka.cstv.databinding.ActivityMatchDetailBinding
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class MatchDetailActivity : BaseActivity() {

    private var _binding: ActivityMatchDetailBinding? = null
    private val binding get() = _binding!!

    override fun getBinding(): View {
        _binding = ActivityMatchDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun initView() {
        val matchDto = bundle?.get(EXTRA_MATCH_DETAIL) as? MatchDto

        binding.ivBack.setOnClickListener { onBackPressed() }

        val leagueName = matchDto?.league?.name
        val serieName = matchDto?.serie?.name

        if (leagueName != null && serieName == null) {
            binding.tvTitle.text = leagueName
        } else if (leagueName == null && serieName != null) {
            binding.tvTitle.text = serieName
        } else {
            binding.tvTitle.text = getString(R.string.league_plus_serie_name, leagueName, serieName)
        }

        val firstTeamLogo = matchDto?.opponentList?.get(0)?.opponent?.imageUrl
        if (firstTeamLogo != null) {
            Glide
                .with(this)
                .load(firstTeamLogo)
                .centerCrop()
                .into(binding.ivFirstTeamLogo)
        }

        val secondTeamLogo = matchDto?.opponentList?.get(1)?.opponent?.imageUrl
        if (secondTeamLogo != null) {
            Glide
                .with(this)
                .load(secondTeamLogo)
                .centerInside()
                .into(binding.ivSecondTeamLogo)
        }

        binding.tvFirstTeamName.text = matchDto?.opponentList?.get(0)?.opponent?.name
        binding.tvSecondTeamName.text = matchDto?.opponentList?.get(1)?.opponent?.name

        val matchStartHour: String =
            OffsetDateTime.parse(matchDto?.beginAt).format(
                DateTimeFormatter.ofPattern(
                    getString(
                        R.string.hours_and_minutes_pattern
                    ), locale
                )
            ).toString()

        binding.tvMatchHour.text = getString(R.string.match_hour, matchStartHour)

//        binding.vTeamOneFirstPlayer.tvNickname.text =
    }

    companion object {
        const val EXTRA_MATCH_DETAIL = "extra_match_detail"
    }

}