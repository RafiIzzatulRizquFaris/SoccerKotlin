package com.example.submission3kotlin.contract

import com.example.submission3kotlin.model.Event

interface NextMatchContract {
    interface View {
        fun setNextMatch(matchList: List<Event>)
    }

    interface Presenter {
        fun getNextMatch(league: String?)
    }
}