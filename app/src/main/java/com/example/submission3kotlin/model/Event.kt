package com.example.submission3kotlin.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class Events(
    var events: List<Event>
)

@Parcelize
data class Event(
    var dateEvent: String?,
    var dateEventLocal: String?,
    var idAwayTeam: String?,
    var idEvent: String?,
    var idHomeTeam: String?,
    var idLeague: String?,
    var idSoccerXML: String?,
    var intAwayScore: String?,
    var intAwayShots: String?,
    var intHomeScore: String?,
    var intHomeShots: String?,
    var intRound: String?,
    var intSpectators: String?,
    var strAwayFormation: String?,
    var strAwayGoalDetails: String?,
    var strAwayLineupDefense: String?,
    var strAwayLineupForward: String?,
    var strAwayLineupGoalkeeper: String?,
    var strAwayLineupMidfield: String?,
    var strAwayLineupSubstitutes: String?,
    var strAwayRedCards: String?,
    var strAwayTeam: String?,
    var strAwayYellowCards: String?,
    var strBanner: String?,
    var strCircuit: String?,
    var strCity: String?,
    var strCountry: String?,
    var strDate: String?,
    var strDescriptionEN: String?,
    var strEvent: String?,
    var strEventAlternate: String?,
    var strFanart: String?,
    var strFilename: String?,
    var strHomeFormation: String?,
    @SerializedName("strHomeGoalDetails") var strHomeGoalDetails: String?,
    var strHomeLineupDefense: String?,
    var strHomeLineupForward: String?,
    var strHomeLineupGoalkeeper: String?,
    var strHomeLineupMidfield: String?,
    var strHomeLineupSubstitutes: String?,
    var strHomeRedCards: String?,
    var strHomeTeam: String?,
    var strHomeYellowCards: String?,
    var strLeague: String?,
    var strLocked: String?,
    var strMap: String?,
    var strPoster: String?,
    var strResult: String?,
    var strSeason: String?,
    var strSport: String?,
    var strTVStation: String?,
    var strThumb: String?,
    var strTime: String?,
    var strTimeLocal: String?,
    var strTweet1: String?,
    var strTweet2: String?,
    var strTweet3: String?,
    var strVideo: String?
) : Parcelable