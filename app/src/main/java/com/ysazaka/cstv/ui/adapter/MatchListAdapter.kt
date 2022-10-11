package com.ysazaka.cstv.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ysazaka.cstv.R
import com.ysazaka.cstv.data.model.match.MatchDto
import com.ysazaka.cstv.databinding.ItemMatchBinding
import com.ysazaka.cstv.ui.MatchListener
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class MatchListAdapter(
    private val matchList: List<MatchDto>,
    private val listener: MatchListener,
    private val context: Context
) : RecyclerView.Adapter<MatchListAdapter.DataViewHolder>() {

    private var _binding: ItemMatchBinding? = null
    private val binding get() = _binding!!

    private val locale: Locale = Locale.getDefault()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        _binding = ItemMatchBinding.inflate(layoutInflater, parent, false)
        return DataViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bindItemView(matchList[position])
    }

    override fun getItemCount(): Int = matchList.size

    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItemView(matchDto: MatchDto) {
            val matchStartHour: String =
                OffsetDateTime.parse(matchDto.beginAt).format(
                    DateTimeFormatter.ofPattern(
                        context.getString(
                            R.string.hours_and_minutes_pattern
                        ), locale
                    )
                ).toString()

            val matchStatus = matchDto.status
            if (matchStatus.equals(context.getString(R.string.status_finished))) {
                binding.tvMatchHour.setBackgroundResource(R.drawable.bg_match_hour_top_right_and_bottom_left_rounded_corners)
            }

            if (matchStatus.equals(context.getString(R.string.status_live))) {
                binding.tvMatchHour.text = context.getString(R.string.now)
            } else {
                binding.tvMatchHour.text = matchStartHour
            }

            val firstTeamLogo = matchDto.opponentList?.get(0)?.opponent?.imageUrl
            if (firstTeamLogo != null) {
                Glide
                    .with(context)
                    .load(firstTeamLogo)
                    .centerCrop()
                    .into(binding.ivFirstTeamLogo)
            }

            val secondTeamLogo = matchDto.opponentList?.get(1)?.opponent?.imageUrl
            if (secondTeamLogo != null) {
                Glide
                    .with(context)
                    .load(secondTeamLogo)
                    .centerInside()
                    .into(binding.ivSecondTeamLogo)
            }

            binding.tvFirstTeamName.text = matchDto.opponentList?.get(0)?.opponent?.name
            binding.tvSecondTeamName.text = matchDto.opponentList?.get(1)?.opponent?.name

            val leagueLogo = matchDto.league?.imageUrl
            if (leagueLogo != null) {
                Glide
                    .with(context)
                    .load(leagueLogo)
                    .centerInside()
                    .into(binding.ivLeagueLogo)
            }

            val leagueName = matchDto.league?.name
            val serieName = matchDto.serie?.name

            if (leagueName != null && serieName == null) {
                binding.tvLeaguePlusSerie.text = leagueName
            } else if (leagueName == null && serieName != null) {
                binding.tvLeaguePlusSerie.text = serieName
            } else {
                binding.tvLeaguePlusSerie.text =
                    context.getString(R.string.league_plus_serie_name, leagueName, serieName)
            }

            binding.clMatchCard.setOnClickListener {
                listener.onMatchClicked(matchDto)
            }
        }
    }

}