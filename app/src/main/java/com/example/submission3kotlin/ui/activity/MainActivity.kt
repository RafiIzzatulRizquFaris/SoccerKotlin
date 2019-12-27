package com.example.submission3kotlin.ui.activity

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentPagerAdapter
import com.example.submission3kotlin.R
import com.example.submission3kotlin.adapter.HomeTabAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sectionAdapter: FragmentPagerAdapter = HomeTabAdapter(this, supportFragmentManager)
        main_view_pager.adapter = sectionAdapter
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) main_tab_layout.setTabTextColors(
            R.color.colorPrimaryDark, getColor(
                R.color.colorWhite
            )
        )
        main_tab_layout.setupWithViewPager(main_view_pager)
    }
}
