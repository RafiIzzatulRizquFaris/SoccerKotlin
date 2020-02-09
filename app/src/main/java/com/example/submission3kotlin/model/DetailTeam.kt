package com.example.submission3kotlin.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class DetailTeam(
    var teams: List<Team>
)

@Parcelize
data class Team(
    var idLeague: String?,
    var idSoccerXML: String?,
    var idTeam: String?,
    var intFormedYear: String?,
    var intLoved: String?,
    var intStadiumCapacity: String?,
    var strAlternate: String?,
    var strCountry: String?,
    var strDescriptionCN: String?,
    var strDescriptionDE: String?,
    var strDescriptionEN: String?,
    var strDescriptionES: String?,
    var strDescriptionFR: String?,
    var strDescriptionHU: String?,
    var strDescriptionIL: String?,
    var strDescriptionIT: String?,
    var strDescriptionJP: String?,
    var strDescriptionNL: String?,
    var strDescriptionNO: String?,
    var strDescriptionPL: String?,
    var strDescriptionPT: String?,
    var strDescriptionRU: String?,
    var strDescriptionSE: String?,
    var strDivision: String?,
    var strFacebook: String?,
    var strGender: String?,
    var strInstagram: String?,
    var strKeywords: String?,
    var strLeague: String?,
    var strLocked: String?,
    var strManager: String?,
    var strRSS: String?,
    var strSport: String?,
    var strStadium: String?,
    var strStadiumDescription: String?,
    var strStadiumLocation: String?,
    var strStadiumThumb: String?,
    var strTeam: String?,
    var strTeamBadge: String?,
    var strTeamBanner: String?,
    var strTeamFanart1: String?,
    var strTeamFanart2: String?,
    var strTeamFanart3: String?,
    var strTeamFanart4: String?,
    var strTeamJersey: String?,
    var strTeamLogo: String?,
    var strTeamShort: String?,
    var strTwitter: String?,
    var strWebsite: String?,
    var strYoutube: String?
) : Parcelable