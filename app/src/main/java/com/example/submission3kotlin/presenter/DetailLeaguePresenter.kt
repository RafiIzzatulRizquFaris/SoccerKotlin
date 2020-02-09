package com.example.submission3kotlin.presenter

import android.util.Log
import com.example.submission3kotlin.DataRepositoryImpl
import com.example.submission3kotlin.SchedulerProvider
import com.example.submission3kotlin.contract.DetailLeagueContract
import io.reactivex.disposables.CompositeDisposable

class DetailLeaguePresenter(
    val view: DetailLeagueContract.View,
    private val scheduler: SchedulerProvider,
    private val request: DataRepositoryImpl
): DetailLeagueContract.Presenter {
    override fun getDetailLeague(id: String) {
        CompositeDisposable().add(
            request.getDetailLeague(id)
                .observeOn(scheduler.ui())
                .subscribeOn(scheduler.io())
                .subscribe(
                    {
                        view.setDetailLeague(it.leagues)
                    }, { error -> Log.e("Error", error.message) }
                )
        )
    }
}