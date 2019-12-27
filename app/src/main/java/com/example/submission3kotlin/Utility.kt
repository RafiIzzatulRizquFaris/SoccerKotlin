package com.example.submission3kotlin

import android.view.View

fun View.gone(){
    visibility = View.GONE
}

fun idling(time: Long){
    try {
        Thread.sleep(time)
    }catch (e: InterruptedException){
        e.printStackTrace()
    }
}