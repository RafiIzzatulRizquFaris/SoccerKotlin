package com.example.submission3kotlin.retrofit

import com.example.submission3kotlin.model.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {
    @GET("lookupleague.php")
    fun responseDetailLeague(
        @Query("id") id: String
    ): Observable<DetailLeague>

    @GET("eventspastleague.php")
    fun responsePastLeague(
        @Query("id") id: String
    ): Observable<Events>

    @GET("eventsnextleague.php")
    fun responseNextLeague(
        @Query("id") id: String
    ): Observable<Events>

    @GET("searchevents.php")
    fun responseSearch(
        @Query("e") query: String
    ): Observable<SearchEvents>

    @GET("lookupevent.php")
    fun responseDetailEvent(
        @Query("id") id: String
    ): Observable<DetailEvents>

    @GET("lookupteam.php")
    fun responseTeam(
        @Query("id") id:String
    ) : Observable<DetailTeam>

    @GET("lookupplayer.php")
    fun responseDetailPlayer(
        @Query("id") id: String
    ) : Observable<DetailPlayer>

    @GET("lookuptable.php")
    fun responseStandings(
        @Query("l") id: String
    ) : Observable<Standings>

    @GET("searchteams.php")
    fun responseSearchTeam(
        @Query("t") query: String
    ) : Observable<SearchTeam>

    @GET("lookup_all_teams.php")
    fun responseListTeam(
        @Query("id") id: String
    ) : Observable<ListTeam>

    @GET("eventsnext.php")
    fun responseNextTeam(
        @Query("id") id: String
    ) : Observable<Events>

    @GET("eventslast.php")
    fun responsePreviousTeam(
        @Query("id") id: String
    ) : Observable<Events>
}