package com.example.submission3kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.submission3kotlin.R
import com.example.submission3kotlin.model.Event
import kotlinx.android.synthetic.main.item_match.view.*

class AdapterNextEvent(
    private val context: Context,
    private val matchList: List<Event>,
    private val listener: (Event) -> Unit
) : RecyclerView.Adapter<AdapterNextEvent.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_match, parent, false))
    }

    override fun getItemCount(): Int = matchList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemBind(matchList[position], listener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun itemBind(event: Event, listener: (Event) -> Unit) {
            itemView.apply {
                tv_match_date.text = event.dateEventLocal
                tv_home_team.text = event.strHomeTeam
                tv_away_team.text = event.strAwayTeam
            }
            itemView.setOnClickListener {
                listener(event)
            }
        }
    }
}