package com.example.submission3kotlin.retrofit

import com.example.submission3kotlin.model.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {
    @GET("lookupleague.php")
    fun responseDetailLeague(
        @Query("id") id: Int
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
}