package com.ecell.esummit

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View

class Dashboard : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)
    }

    fun Technology(v: View){
        get_schedule("1")
    }

    fun Startup(v: View){
        get_schedule("2")
    }

    fun Business(v: View){
        get_schedule("3")
    }

    fun Innovation(v: View){
        get_schedule("4")
    }

    fun get_schedule(track: String){
        val intent = Intent(baseContext, Tracks::class.java)
        intent.putExtra("track", track)
        startActivity(intent)
    }
}
