package com.example.submission3kotlin

import com.example.submission3kotlin.contract.DetailLeagueContract
import com.example.submission3kotlin.model.DetailLeague
import com.example.submission3kotlin.model.League
import com.example.submission3kotlin.presenter.DetailLeaguePresenter
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class DetailLeagueTest {
    @Mock
    lateinit var view: DetailLeagueContract.View

    @Mock
    lateinit var dataRepositoryImpl: DataRepositoryImpl

    @Mock
    lateinit var scheduler: SchedulerProvider

    private lateinit var mPresenter: DetailLeaguePresenter

    private lateinit var league: DetailLeague

    private lateinit var detailLeague: Observable<DetailLeague>

    private val leagues: MutableList<League> = mutableListOf()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        scheduler = TestSchedulerProvider()
        league = DetailLeague(leagues)
        detailLeague = Observable.just(league)
        mPresenter = DetailLeaguePresenter(view, scheduler, dataRepositoryImpl)
        `when`(dataRepositoryImpl.getDetailLeague("4328")).thenReturn(detailLeague)
    }

    @Test
    fun getDetailLeague() {
        mPresenter.getDetailLeague("4328")
        Mockito.verify(view).setDetailLeague(leagues)
    }
}