package com.example.submission3kotlin.presenter

import android.util.Log
import com.example.submission3kotlin.DataRepositoryImpl
import com.example.submission3kotlin.SchedulerProvider
import com.example.submission3kotlin.contract.NextMatchContract
import io.reactivex.disposables.CompositeDisposable

class NextMatchPresenter(val view: NextMatchContract.View,
                         private val scheduler: SchedulerProvider,
                         private val request: DataRepositoryImpl) : NextMatchContract.Presenter {
    override fun getNextMatch(
        league: String?
    ) {
        CompositeDisposable().add(
            request.getNextLeague(league.toString())
                .observeOn(scheduler.ui())
                .subscribeOn(scheduler.io())
                .subscribe(
                    {
                        view.setNextMatch(it.events)
                    }, { error -> Log.e("Error", error.message) }
                )
        )
    }
}