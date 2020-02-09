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
import com.example.submission3kotlin.adapter.AdapterPreviousEvent
import com.example.submission3kotlin.contract.PreviousMatchContract
import com.example.submission3kotlin.gone
import com.example.submission3kotlin.model.Event
import com.example.submission3kotlin.presenter.PreviousMatchPresenter
import com.example.submission3kotlin.retrofit.RetrofitClient
import com.example.submission3kotlin.retrofit.UserService
import com.example.submission3kotlin.ui.activity.DetailEventActivity
import kotlinx.android.synthetic.main.fragment_previous_match.*
import org.jetbrains.anko.support.v4.startActivity

/**
 * A simple [Fragment] subclass.
 */
class PreviousMatchFragment : Fragment(), PreviousMatchContract.View {

    private lateinit var mPresenter: PreviousMatchPresenter
    private var matchLists: MutableList<Event> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_previous_match, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val scheduler = AppSchedulerProvider()
        val retrofitClient = RetrofitClient.getClient().create(UserService::class.java)
        val request = DataRepositoryImpl(retrofitClient)
        mPresenter = PreviousMatchPresenter(this, scheduler, request)
        val strtext = arguments!!.getString("idleagues")
        Log.e("PreviousMatchFragment", strtext!!)
        rv_previous_match.layoutManager = LinearLayoutManager(context)
        rv_previous_match.setHasFixedSize(true)
        rv_previous_match.adapter = AdapterPreviousEvent(context!!, matchLists) {
            startActivity<DetailEventActivity>("detail_event" to it)
        }
        mPresenter.getPreviousMatch(strtext)
    }

    override fun setPreviousMatch(matchList: List<Event>) {
        if (matchList.isNotEmpty()) {
            matchLists.clear()
            matchLists.addAll(matchList)
            rv_previous_match.adapter!!.notifyDataSetChanged()
            pg_previous_match.gone()
        } else Toast.makeText(context, "List is not Empty", Toast.LENGTH_LONG).show()
    }
}
