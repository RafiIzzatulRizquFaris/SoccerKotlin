package com.example.submission3kotlin.presenter

import android.util.Log
import com.example.submission3kotlin.DataRepositoryImpl
import com.example.submission3kotlin.SchedulerProvider
import com.example.submission3kotlin.contract.PreviousMatchContract
import io.reactivex.disposables.CompositeDisposable

class PreviousMatchPresenter(val view: PreviousMatchContract.View,
                             private val scheduler: SchedulerProvider,
                             private val request: DataRepositoryImpl
) : PreviousMatchContract.Presenter {
    override fun getPreviousMatch(league: String?) {
        CompositeDisposable().add(
            request.getPastLeague(league.toString())
                .observeOn(scheduler.ui())
                .subscribeOn(scheduler.io())
                .subscribe(
                    {
                        view.setPreviousMatch(it.events)
                    }, { error -> Log.e("Error", error.message) }
                )
        )
    }
}