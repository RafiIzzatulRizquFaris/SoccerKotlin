package com.example.submission3kotlin.contract

import com.example.submission3kotlin.model.League

interface DetailLeagueContract {
    interface View{
        fun setDetailLeague(listLeague: List<League>)
    }

    interface Presenter {
        fun getDetailLeague(id: String)
    }
}