package com.example.submission3kotlin.presenter

import android.util.Log
import com.example.submission3kotlin.DataRepositoryImpl
import com.example.submission3kotlin.SchedulerProvider
import com.example.submission3kotlin.contract.SearchMatchContract
import io.reactivex.disposables.CompositeDisposable

class SearchMatchPresenter(val view: SearchMatchContract.View,
                           private val scheduler: SchedulerProvider,
                           private val request: DataRepositoryImpl
) : SearchMatchContract.Presenter {
    override fun getSearchMatch(strQuery: String?) {
        CompositeDisposable().add(
            request.getSearch(strQuery.toString())
                .observeOn(scheduler.ui())
                .subscribeOn(scheduler.io())
                .subscribe(
                    {
                        view.setSearchMatch(it.searchevent)
                    }, { error -> Log.e("Error", error.message) }
                )
        )
    }
}