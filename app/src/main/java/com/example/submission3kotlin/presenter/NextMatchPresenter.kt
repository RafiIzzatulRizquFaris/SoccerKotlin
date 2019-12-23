package com.example.submission3kotlin.presenter

import android.util.Log
import com.example.submission3kotlin.contract.NextMatchContract
import com.example.submission3kotlin.retrofit.RetrofitClient
import com.example.submission3kotlin.retrofit.UserService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class NextMatchPresenter(val view: NextMatchContract.View) : NextMatchContract.Presenter {
    override fun getNextMatch(league: String?) {
        val retrofit = RetrofitClient.getClient()
            .create(UserService::class.java)
        CompositeDisposable().add(
            retrofit.responseNextLeague(league.toString())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        view.setNextMatch(it.events)
                    }, { error -> Log.e("Error", error.message) }
                )
        )
    }
}