package com.example.submission3kotlin.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.submission3kotlin.R
import com.example.submission3kotlin.ui.fragment.FavoriteFragment
import com.example.submission3kotlin.ui.fragment.LeagueFragment

class HomeTabAdapter(private val context: Context, fm: FragmentManager): FragmentPagerAdapter(fm)  {

    private val title = intArrayOf(R.string.title_league, R.string.title_favorite)

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(title[position])
    }

    override fun getItem(position: Int): Fragment {
        val fragment: Fragment? = null
        when(position){
            0 -> return LeagueFragment()
            1 -> return FavoriteFragment()
        }
        return fragment!!
    }

    override fun getCount(): Int {
        return title.size
    }
}