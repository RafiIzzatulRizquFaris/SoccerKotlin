package com.example.submission3kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submission3kotlin.R
import com.example.submission3kotlin.model.Item
import kotlinx.android.synthetic.main.item_league.view.*

class AdapterItem(
    private val context: Context,
    private val items: List<Item>,
    private val listener: (Item) -> Unit
) : RecyclerView.Adapter<AdapterItem.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_league, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemBind(items[position], listener)
    }

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun itemBind(item: Item, listener: (Item) -> Unit) {
            itemView.apply {
                Glide.with(context).load(item.image).into(img_league)
                name_league.text = item.name
            }
            itemView.setOnClickListener {
                listener(item)
            }
        }
    }
}