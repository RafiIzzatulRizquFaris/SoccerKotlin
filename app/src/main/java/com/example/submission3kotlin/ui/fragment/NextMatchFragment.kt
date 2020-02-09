package com.example.submission3kotlin.ui.fragment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission3kotlin.AppSchedulerProvider
import com.example.submission3kotlin.DataRepositoryImpl

import com.example.submission3kotlin.R
import com.example.submission3kotlin.adapter.AdapterNextEvent
import com.example.submission3kotlin.contract.NextMatchContract
import com.example.submission3kotlin.gone
import com.example.submission3kotlin.model.Event
import com.example.submission3kotlin.presenter.NextMatchPresenter
import com.example.submission3kotlin.retrofit.RetrofitClient
import com.example.submission3kotlin.retrofit.UserService
import com.example.submission3kotlin.ui.activity.DetailEventActivity
import kotlinx.android.synthetic.main.fragment_next_match.*
import org.jetbrains.anko.support.v4.startActivity

/**
 * A simple [Fragment] subclass.
 */
class NextMatchFragment : Fragment(), NextMatchContract.View {

    private lateinit var mPresenter: NextMatchPresenter
    private var matchLists: MutableList<Event> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_next_match, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val strtext = arguments!!.getString("idleagues")
        val scheduler = AppSchedulerProvider()
        val retrofitClient = RetrofitClient.getClient().create(UserService::class.java)
        val request = DataRepositoryImpl(retrofitClient)
        mPresenter = NextMatchPresenter(this, scheduler, request)
        Log.e("NextMatchFragment", strtext!!)
        rv_next_match.layoutManager = LinearLayoutManager(context)
        rv_next_match.setHasFixedSize(true)
        rv_next_match.adapter = AdapterNextEvent(context!!, matchLists) {
            startActivity<DetailEventActivity>("detail_event" to it)
        }
        mPresenter.getNextMatch(strtext)
    }

    override fun setNextMatch(matchList: List<Event>) {
        if (matchList.isNotEmpty()) {
            matchLists.clear()
            matchLists.addAll(matchList)
            rv_next_match.adapter!!.notifyDataSetChanged()
            pg_next_match.gone()
        } else Toast.makeText(context, "List is Empty", Toast.LENGTH_LONG).show()
    }
}
