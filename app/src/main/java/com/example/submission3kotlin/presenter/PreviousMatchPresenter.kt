package com.example.submission3kotlin.presenter

import android.util.Log
import com.example.submission3kotlin.contract.PreviousMatchContract
import com.example.submission3kotlin.retrofit.RetrofitClient
import com.example.submission3kotlin.retrofit.UserService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PreviousMatchPresenter(val view: PreviousMatchContract.View) :
    PreviousMatchContract.Presenter {
    override fun getPreviousMatch(league: String?) {
        val retrofit = RetrofitClient.getClient()
            .create(UserService::class.java)
        CompositeDisposable().add(
            retrofit.responsePastLeague(league.toString())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        view.setPreviousMatch(it.events)
                    }, { error -> Log.e("Error", error.message) }
                )
        )
    }
}