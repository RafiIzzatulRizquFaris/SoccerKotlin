package com.example.submission3kotlin.presenter

import android.util.Log
import com.example.submission3kotlin.contract.DetailSearchContract
import com.example.submission3kotlin.retrofit.RetrofitClient
import com.example.submission3kotlin.retrofit.UserService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DetailSearchPresenter (val view: DetailSearchContract.View): DetailSearchContract.Presenter {

    private val retrofit = RetrofitClient.getClient().create(UserService::class.java)

    override fun getDetailSearch(id: String) {
        CompositeDisposable().add(
            retrofit.responseDetailEvent(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        view.setDetailSearch(it.events)
                    }, { error -> Log.e("Error", error.message) }
                )
        )
    }

    override fun getDetailTeamHome(id: String) {
        CompositeDisposable().add(
            retrofit.responseTeam(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        view.setDetailTeamHome(it.teams)
                    }, {error -> Log.e("Error", error.message) }
                )
        )
    }

    override fun getDetailTeamAway(id: String) {
        CompositeDisposable().add(
            retrofit.responseTeam(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        view.setDetailTeamAway(it.teams)
                    }, {error -> Log.e("Error", error.message) }
                )
        )
    }
}