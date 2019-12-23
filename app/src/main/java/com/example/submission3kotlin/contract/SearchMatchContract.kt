package com.example.submission3kotlin.contract

import com.example.submission3kotlin.model.SearchEvent

interface SearchMatchContract {
    interface View {
        fun setSearchMatch(listMatch: List<SearchEvent>?)
    }

    interface Presenter {
        fun getSearchMatch(strQuery: String?)
    }
}