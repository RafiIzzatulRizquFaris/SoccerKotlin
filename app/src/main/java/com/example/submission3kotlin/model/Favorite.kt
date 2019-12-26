package com.example.submission3kotlin.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Favorite (
    val id: Long?,
    val idEvent: String?,
    val strHome: String?,
    val strAway: String?,
    val scoreHome: String?,
    val scoreAway: String?,
    val imgHome: String?,
    val imgAway: String?,
    val dateEvent: String?) : Parcelable {
    companion object{
        const val TABLE_NAME: String = "TABLE_FAVORITE"
        const val ID: String = "ID_"
        const val ID_EVENT: String = "ID_EVENT"
        const val STR_HOME: String = "STR_HOME"
        const val STR_AWAY: String = "STR_AWAY"
        const val SCORE_HOME: String = "SCORE_HOME"
        const val SCORE_AWAY: String = "SCORE_AWAY"
        const val IMG_HOME: String = "IMG_HOME"
        const val IMG_AWAY: String = "IMG_AWAY"
        const val DATE_EVENT: String = "DATE_EVENT"
    }
}