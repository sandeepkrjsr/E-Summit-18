package com.ecell.esummit

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import java.util.concurrent.TimeUnit

/**
 * Created by 1505560 on 22-Feb-18.
 */
class Splash : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)

        val timer = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(2000)
                } catch (e: Exception) {

                } finally {
                    val intent = Intent(baseContext, Registration::class.java)
                    startActivity(intent)
                }
            }
        }
        timer.start()
    }
}