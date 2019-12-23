package com.example.submission3kotlin.contract

import com.example.submission3kotlin.model.Event
import com.example.submission3kotlin.model.Team

interface DetailSearchContract {
        interface View{
            fun setDetailSearch(listEvent: List<Event>)
            fun setDetailTeamHome(listTeam: List<Team>)
            fun setDetailTeamAway(listTeam: List<Team>)
        }
        interface Presenter{
            fun getDetailSearch(id: String)
            fun getDetailTeamHome(id: String)
            fun getDetailTeamAway(id: String)
        }
}