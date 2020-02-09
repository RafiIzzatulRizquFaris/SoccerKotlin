package com.example.submission3kotlin.adapter

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.submission3kotlin.R
import com.example.submission3kotlin.ui.fragment.NextMatchFragment
import com.example.submission3kotlin.ui.fragment.PreviousMatchFragment
import com.example.submission3kotlin.ui.fragment.StandingsFragment
import com.example.submission3kotlin.ui.fragment.TeamFragment

class TabFragmentAdapter(
    private val cContext: Context,
    fm: FragmentManager,
    private val myidleagues: String
) :
    FragmentPagerAdapter(fm) {

    private val title = intArrayOf(R.string.previous_match, R.string.next_match, R.string.title_standings, R.string.title_team)

    override fun getItem(position: Int): Fragment {
        val fragment: Fragment? = null
        when (position) {
            0 -> {
                val bundle = Bundle()
                val previousFragment = PreviousMatchFragment()
                bundle.putString("idleagues", myidleagues)
                previousFragment.arguments = bundle
                return previousFragment
            }
            1 -> {
                val bundle = Bundle()
                val nextFragment = NextMatchFragment()
                bundle.putString("idleagues", myidleagues)
                nextFragment.arguments = bundle
                return nextFragment
            }
            2 -> {
                val bundle = Bundle()
                val standingsFragment = StandingsFragment()
                bundle.putString("idleagues", myidleagues)
                standingsFragment.arguments = bundle
                return standingsFragment
            }
            3 -> {
                val bundle = Bundle()
                val teamFragment = TeamFragment()
                bundle.putString("idleagues", myidleagues)
                teamFragment.arguments = bundle
                return teamFragment
            }
        }
        return fragment!!
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return cContext.resources.getString(title[position])
    }

    override fun getCount(): Int {
        return title.size
    }
}