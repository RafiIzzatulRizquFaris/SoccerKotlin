package com.example.submission3kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.submission3kotlin.R
import com.example.submission3kotlin.model.Favorite
import kotlinx.android.synthetic.main.item_match.view.*

class AdapterFavorite(
    private val context: Context,
    private val matchList: List<Favorite>,
    private val listener: (Favorite) -> Unit
) : RecyclerView.Adapter<AdapterFavorite.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_match, parent, false))
    }

    override fun getItemCount(): Int = matchList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemBind(matchList[position], listener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun itemBind(favorite: Favorite, listener: (Favorite) -> Unit) {
            itemView.apply {
                tv_match_date.text = favorite.dateEvent
                tv_home_team.text = favorite.strHome
                tv_away_team.text = favorite.strAway
                tv_score_team_home.text = favorite.scoreHome
                tv_score_team_away.text = favorite.scoreAway
            }
            itemView.setOnClickListener {
                listener(favorite)
            }
        }
    }
}