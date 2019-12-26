package com.example.submission3kotlin.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission3kotlin.R
import com.example.submission3kotlin.adapter.AdapterItem
import com.example.submission3kotlin.model.Item
import com.example.submission3kotlin.ui.activity.DetailLeagueActivity
import kotlinx.android.synthetic.main.fragment_league.*
import org.jetbrains.anko.support.v4.startActivity

class LeagueFragment : Fragment() {

    private val items: MutableList<Item> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_league, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getData()
        rv_league.layoutManager = LinearLayoutManager(context)
        rv_league.adapter = AdapterItem(context!!, items){
            startActivity<DetailLeagueActivity>("detail" to it)
        }
    }

    private fun getData() {
        val id = resources.getStringArray(R.array.league_id)
        val name = resources.getStringArray(R.array.league_name)
        val desc = resources.getStringArray(R.array.league_desc)
        val img = resources.obtainTypedArray(R.array.league_image)

        for (i in id.indices) {
            items.add(Item(id[i], name[i], desc[i], img.getResourceId(i, 0)))
        }
        img.recycle()
    }
}