package com.example.submission3kotlin.ui.activity

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import androidx.fragment.app.FragmentPagerAdapter
import com.bumptech.glide.Glide
import com.example.submission3kotlin.AppSchedulerProvider
import com.example.submission3kotlin.DataRepositoryImpl
import com.example.submission3kotlin.R
import com.example.submission3kotlin.adapter.TabFragmentAdapter
import com.example.submission3kotlin.contract.DetailLeagueContract
import com.example.submission3kotlin.gone
import com.example.submission3kotlin.model.Item
import com.example.submission3kotlin.model.League
import com.example.submission3kotlin.presenter.DetailLeaguePresenter
import com.example.submission3kotlin.retrofit.RetrofitClient
import com.example.submission3kotlin.retrofit.UserService
import kotlinx.android.synthetic.main.activity_detail_league.*

class DetailLeagueActivity : AppCompatActivity(), DetailLeagueContract.View {

    private lateinit var mPresenter: DetailLeaguePresenter
    private var myIdLeague: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_league)
        val intentLeague: Item? = intent.getParcelableExtra("detail")
        val scheduler = AppSchedulerProvider()
        val retrofitClient = RetrofitClient.getClient().create(UserService::class.java)
        val request = DataRepositoryImpl(retrofitClient)
        mPresenter = DetailLeaguePresenter(this, scheduler, request)
        myIdLeague = intentLeague!!.id!!.toString()
        Glide.with(this).load(intentLeague.image).into(posterLeague)
        mPresenter.getDetailLeague(myIdLeague!!)
        setSliderFragment()
    }

    private fun setSliderFragment() {
        val sectionsPagerAdapter: FragmentPagerAdapter =
            TabFragmentAdapter(this, supportFragmentManager, myIdLeague.toString())
        view_pager.adapter = sectionsPagerAdapter
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) tab_layout.setTabTextColors(
            R.color.colorPrimaryDark, getColor(
                R.color.colorWhite
            )
        )
        tab_layout.setupWithViewPager(view_pager)
    }

    override fun setDetailLeague(listLeague: List<League>) {
        supportActionBar!!.title = listLeague[0].strLeague
        txtLeagueName.text = listLeague[0].strLeague
        txtLeagueDescriptionEN.text = listLeague[0].strDescriptionEN
        ftvFacebook.setOnClickListener { openInBrowser(listLeague[0].strFacebook) }
        ftvTwitter.setOnClickListener { openInBrowser(listLeague[0].strTwitter) }
        ftvWebsite.setOnClickListener { openInBrowser(listLeague[0].strWebsite) }
        ftvYoutube.setOnClickListener { openInBrowser(listLeague[0].strYoutube) }
        progressBar.gone()
    }

    private fun openInBrowser(myURL: String?) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://$myURL")))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu!!.findItem(R.id.search).actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = resources.getString(R.string.query_hint)
        searchView.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                val intent = Intent(this@DetailLeagueActivity, SearchEventActivity::class.java)
                intent.putExtra("query_event", query)
                startActivity(intent)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean = false
        })
        return true
    }
}
