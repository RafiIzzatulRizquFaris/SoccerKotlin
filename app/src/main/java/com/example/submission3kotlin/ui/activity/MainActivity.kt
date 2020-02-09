package com.example.submission3kotlin.ui.activity

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView.OnQueryTextListener
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu!!.findItem(R.id.search).actionView as android.widget.SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = "Search Your Team"
        searchView.setOnQueryTextListener(object : OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                val intent = Intent(this@MainActivity, SearchTeamActivity::class.java)
                intent.putExtra("query_team", query)
                startActivity(intent)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean = false
        })
        return true
    }
}
