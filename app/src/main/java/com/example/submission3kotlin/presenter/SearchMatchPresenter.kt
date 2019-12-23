package com.example.submission3kotlin.presenter

import android.util.Log
import com.example.submission3kotlin.contract.SearchMatchContract
import com.example.submission3kotlin.retrofit.RetrofitClient
import com.example.submission3kotlin.retrofit.UserService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SearchMatchPresenter(val view: SearchMatchContract.View) : SearchMatchContract.Presenter {
    override fun getSearchMatch(strQuery: String?) {
        Log.e("TAG", strQuery.toString())
        val retrofit = RetrofitClient.getClient()
            .create(UserService::class.java)
        CompositeDisposable().add(
            retrofit.responseSearch(strQuery.toString())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        view.setSearchMatch(it.searchevent)
                    }, { error -> Log.e("Error", error.message) }
                )
        )
    }
}