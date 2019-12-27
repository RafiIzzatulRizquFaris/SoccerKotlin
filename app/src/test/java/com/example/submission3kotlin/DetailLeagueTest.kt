package com.example.submission3kotlin

import com.example.submission3kotlin.contract.DetailLeagueContract
import com.example.submission3kotlin.model.DetailLeague
import com.example.submission3kotlin.model.League
import com.example.submission3kotlin.presenter.DetailLeaguePresenter
import com.example.submission3kotlin.retrofit.RetrofitClient
import com.example.submission3kotlin.retrofit.UserService
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class DetailLeagueTest {
        @Mock
        lateinit var view: DetailLeagueContract.View

        @Mock
        private val retrofitClient = RetrofitClient.getClient().create(UserService::class.java)

        private lateinit var mPresenter: DetailLeaguePresenter

        private lateinit var league: DetailLeague

        private lateinit var detailLeague: Observable<DetailLeague>

        private val leagues = mutableListOf<League>()

        @Before
        fun setUp(){
            MockitoAnnotations.initMocks(this)
            league = DetailLeague(leagues)
            detailLeague = Observable.just(league)
            mPresenter = DetailLeaguePresenter(view)
            Mockito.`when`(retrofitClient.responseDetailLeague("4328")).thenReturn(detailLeague)
        }

        @Test
        fun getDetailLeague() {
            mPresenter.getDetailLeague("4328")
            Mockito.verify(view).setDetailLeague(leagues)
        }
}