package com.example.submission3kotlin.ui.fragment

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getColor
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.example.submission3kotlin.R
import com.example.submission3kotlin.adapter.FavoriteTabAdapter
import kotlinx.android.synthetic.main.fragment_favorite.*

class FavoriteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val sectionAdapter: FragmentPagerAdapter = FavoriteTabAdapter(context!!, fragmentManager!!)
        favorite_view_pager.adapter = sectionAdapter
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) favorite_tab_layout.setTabTextColors(
            R.color.colorPrimaryDark, getColor(
                context!!, R.color.colorWhite
            )
        )
        favorite_tab_layout.setupWithViewPager(favorite_view_pager)
    }
}