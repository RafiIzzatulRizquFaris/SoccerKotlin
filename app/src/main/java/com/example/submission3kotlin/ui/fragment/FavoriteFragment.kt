package com.example.submission3kotlin.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission3kotlin.R
import com.example.submission3kotlin.adapter.AdapterFavorite
import com.example.submission3kotlin.database
import com.example.submission3kotlin.model.Favorite
import com.example.submission3kotlin.ui.activity.DetailFavoriteActivity
import kotlinx.android.synthetic.main.fragment_favorite.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.startActivity

class FavoriteFragment : Fragment() {

    private var matchList: MutableList<Favorite> = mutableListOf()
    private lateinit var adapter: AdapterFavorite

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rv_favorite.layoutManager = LinearLayoutManager(context)
        adapter = AdapterFavorite(context!!, matchList){
            startActivity<DetailFavoriteActivity>("detail_favorite" to it)
        }
        rv_favorite.adapter = adapter
        swipe_refresh.onRefresh {
            showFavorite()
        }
    }

    override fun onResume() {
        super.onResume()
        showFavorite()
    }

    private fun showFavorite() {
        matchList.clear()
        context?.database?.use {
            swipe_refresh.isRefreshing = false
            val result = select(Favorite.TABLE_NAME)
            val favorite = result.parseList(classParser<Favorite>())
            matchList.addAll(favorite)
            adapter.notifyDataSetChanged()
            if(favorite.isEmpty()) Toast.makeText(context, "Your Favorite List is Empty", Toast.LENGTH_LONG).show()
        }
    }
}