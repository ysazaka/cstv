package com.ysazaka.cstv.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.ysazaka.cstv.R
import com.ysazaka.cstv.base.BaseActivity
import com.ysazaka.cstv.data.model.match.MatchDto
import com.ysazaka.cstv.data.model.match.PlayerDto
import com.ysazaka.cstv.databinding.ActivityMatchDetailBinding
import com.ysazaka.cstv.viewmodel.GetListOfPlayersOfATeamViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class MatchDetailActivity : BaseActivity() {

    private var _binding: ActivityMatchDetailBinding? = null
    private val binding get() = _binding!!

    private var currentTeamOnePlayerList: List<PlayerDto> = listOf()
    private var currentTeamTwoPlayerList: List<PlayerDto> = listOf()
    private val getListOfPlayersOfATeamViewModel by viewModel<GetListOfPlayersOfATeamViewModel>()

    override fun getBinding(): View {
        _binding = ActivityMatchDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun initView() {
        val matchDto = bundle?.get(EXTRA_MATCH_DETAIL) as? MatchDto
        initObservers()

        if (currentTeamOnePlayerList.isEmpty()) {
            getListOfPlayersOfATeamViewModel.getListOfPlayersOfTeamOne(matchDto?.opponentList?.get(0)?.opponent?.id!!)
        }
        if (currentTeamTwoPlayerList.isEmpty()) {
            getListOfPlayersOfATeamViewModel.getListOfPlayersOfTeamTwo(matchDto?.opponentList?.get(1)?.opponent?.id!!)
        }

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
    }

    private fun initObservers() {
        getListOfPlayersOfATeamViewModel.loadingState.observe(::getLifecycle, ::setLoading)
        getListOfPlayersOfATeamViewModel.teamOnePlayersSuccessState.observe(
            ::getLifecycle,
            ::setTeamOnePlayerList
        )
        getListOfPlayersOfATeamViewModel.teamTwoPlayersSuccessState.observe(
            ::getLifecycle,
            ::setTeamTwoPlayerList
        )
    }

    private fun setLoading(statusLoading: Boolean) {
        loading.visibility = if (statusLoading) View.VISIBLE else View.GONE
    }

    private fun setPlayerInfo(
        tvNickname: TextView,
        tvPlayerName: TextView,
        ivPlayer: ImageView,
        playerDto: PlayerDto
    ) {
        tvNickname.text = playerDto.nickname
        tvPlayerName.text = getString(
            R.string.player_real_name,
            playerDto.firstName,
            playerDto.lastName
        )
        if (playerDto.imageUrl != null) {
            Glide
                .with(this)
                .load(playerDto.imageUrl)
                .centerInside()
                .into(ivPlayer)
        }
    }

    private fun setTeamOnePlayerList(list: List<PlayerDto>) {
        currentTeamOnePlayerList = list

        setPlayerInfo(
            binding.vTeamOneFirstPlayer.tvNickname,
            binding.vTeamOneFirstPlayer.tvPlayerName,
            binding.vTeamOneFirstPlayer.ivPlayer,
            currentTeamOnePlayerList[0]
        )

        setPlayerInfo(
            binding.vTeamOneSecondPlayer.tvNickname,
            binding.vTeamOneSecondPlayer.tvPlayerName,
            binding.vTeamOneSecondPlayer.ivPlayer,
            currentTeamOnePlayerList[1]
        )

        setPlayerInfo(
            binding.vTeamOneThirdPlayer.tvNickname,
            binding.vTeamOneThirdPlayer.tvPlayerName,
            binding.vTeamOneThirdPlayer.ivPlayer,
            currentTeamOnePlayerList[2]
        )

        setPlayerInfo(
            binding.vTeamOneFourthPlayer.tvNickname,
            binding.vTeamOneFourthPlayer.tvPlayerName,
            binding.vTeamOneFourthPlayer.ivPlayer,
            currentTeamOnePlayerList[3]
        )

        setPlayerInfo(
            binding.vTeamOneFifthPlayer.tvNickname,
            binding.vTeamOneFifthPlayer.tvPlayerName,
            binding.vTeamOneFifthPlayer.ivPlayer,
            currentTeamOnePlayerList[4]
        )
    }

    private fun setTeamTwoPlayerList(list: List<PlayerDto>) {
        currentTeamTwoPlayerList = list

        setPlayerInfo(
            binding.vTeamTwoFirstPlayer.tvNickname,
            binding.vTeamTwoFirstPlayer.tvPlayerName,
            binding.vTeamTwoFirstPlayer.ivPlayer,
            currentTeamTwoPlayerList[0]
        )

        setPlayerInfo(
            binding.vTeamTwoSecondPlayer.tvNickname,
            binding.vTeamTwoSecondPlayer.tvPlayerName,
            binding.vTeamTwoSecondPlayer.ivPlayer,
            currentTeamTwoPlayerList[1]
        )

        setPlayerInfo(
            binding.vTeamTwoThirdPlayer.tvNickname,
            binding.vTeamTwoThirdPlayer.tvPlayerName,
            binding.vTeamTwoThirdPlayer.ivPlayer,
            currentTeamTwoPlayerList[2]
        )

        setPlayerInfo(
            binding.vTeamTwoFourthPlayer.tvNickname,
            binding.vTeamTwoFourthPlayer.tvPlayerName,
            binding.vTeamTwoFourthPlayer.ivPlayer,
            currentTeamTwoPlayerList[3]
        )

        setPlayerInfo(
            binding.vTeamTwoFifthPlayer.tvNickname,
            binding.vTeamTwoFifthPlayer.tvPlayerName,
            binding.vTeamTwoFifthPlayer.ivPlayer,
            currentTeamTwoPlayerList[4]
        )
    }

    companion object {
        const val EXTRA_MATCH_DETAIL = "extra_match_detail"
    }

}