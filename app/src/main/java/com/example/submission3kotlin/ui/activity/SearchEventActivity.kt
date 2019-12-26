package com.example.submission3kotlin.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission3kotlin.R
import com.example.submission3kotlin.adapter.AdapterSearchEvent
import com.example.submission3kotlin.contract.SearchMatchContract
import com.example.submission3kotlin.gone
import com.example.submission3kotlin.model.SearchEvent
import com.example.submission3kotlin.presenter.SearchMatchPresenter
import kotlinx.android.synthetic.main.activity_search_event.*
import org.jetbrains.anko.startActivity

class SearchEventActivity : AppCompatActivity(), SearchMatchContract.View {

    private lateinit var mPresenter: SearchMatchPresenter
    private var matchLists: MutableList<SearchEvent> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_event)
        mPresenter = SearchMatchPresenter(this)
        val strQuery = intent?.getStringExtra("query_event")
        supportActionBar!!.title = "Result For : $strQuery"
        rv_search_match.layoutManager = LinearLayoutManager(this)
        rv_search_match.setHasFixedSize(true)
        rv_search_match.adapter = AdapterSearchEvent(applicationContext!!, matchLists) {
            startActivity<DetailSearchActivity>("detail_search" to it)
        }
        mPresenter.getSearchMatch(strQuery!!)
        Toast.makeText(this, strQuery, Toast.LENGTH_LONG).show()
    }

    override fun setSearchMatch(listMatch: List<SearchEvent>?) {
        if(listMatch!!.isNotEmpty()) {
            matchLists.clear()
            matchLists.addAll(listMatch)
            rv_search_match.adapter!!.notifyDataSetChanged()
            pg_search_match.gone()
        }
    }
}
