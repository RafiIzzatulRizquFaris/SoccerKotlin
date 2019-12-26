package com.example.submission3kotlin.adapter

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.submission3kotlin.R
import com.example.submission3kotlin.ui.fragment.NextMatchFragment
import com.example.submission3kotlin.ui.fragment.PreviousMatchFragment

class TabFragmentAdapter(
    private val cContext: Context,
    fm: FragmentManager,
    private val myidleagues: String
) :
    FragmentPagerAdapter(fm) {

    private val title = intArrayOf(R.string.previous_match, R.string.next_match)

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