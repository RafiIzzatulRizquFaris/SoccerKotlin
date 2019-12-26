package com.example.submission3kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.submission3kotlin.R
import com.example.submission3kotlin.model.SearchEvent
import kotlinx.android.synthetic.main.item_match.view.*

class AdapterSearchEvent(
    private val context: Context,
    private val matchList: List<SearchEvent>,
    private val listener: (SearchEvent) -> Unit
) : RecyclerView.Adapter<AdapterSearchEvent.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_match, parent, false))
    }

    override fun getItemCount(): Int = matchList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemBind(matchList[position], listener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun itemBind(searchEvent: SearchEvent, listener: (SearchEvent) -> Unit) {
            itemView.apply {
                tv_match_date.text = searchEvent.dateEventLocal
                tv_home_team.text = searchEvent.strHomeTeam
                tv_away_team.text = searchEvent.strAwayTeam
            }
            itemView.setOnClickListener {
                listener(searchEvent)
            }
        }
    }
}