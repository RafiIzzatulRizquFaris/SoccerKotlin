package com.example.submission3kotlin.contract

import com.example.submission3kotlin.model.Event

interface PreviousMatchContract {
    interface View {
        fun setPreviousMatch(matchList: List<Event>)
    }

    interface Presenter {
        fun getPreviousMatch(league: String?)
    }
}