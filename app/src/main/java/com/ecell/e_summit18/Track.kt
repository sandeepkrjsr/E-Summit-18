package com.ecell.e_summit18

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.TextView

/**
 * Created by 1505560 on 21-Feb-18.
 */

/*
class Track : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tracks)
    }
}*/
class Track : AppCompatActivity() {
    internal lateinit var get_track: String
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null
    internal lateinit var trackname: TextView
    internal lateinit var toolbar: Toolbar

    private var mViewPager: ViewPager? = null
    internal lateinit var tabs: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tracks)

        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        val actionBar = supportActionBar

        actionBar!!.hide()

        //toolbar = findViewById(R.id.toolbar) as Toolbar
        tabs = findViewById(R.id.tabs) as TabLayout
        mViewPager = findViewById(R.id.container) as ViewPager
        mViewPager!!.adapter = mSectionsPagerAdapter

        //trackname = findViewById(R.id.trackname) as TextView

        get_track = intent.getStringExtra("track")


        /*if (get_track == "1") {
            //trackname.text = "TECH TRACK"
            toolbar.setBackgroundColor(resources.getColor(R.color.tech_blue))
            tabs.setBackgroundColor(resources.getColor(R.color.tech_blue))


        }

        if (get_track == "2") {
            //trackname.text = "STARTUP PLANET"
            toolbar.setBackgroundColor(resources.getColor(R.color.startupplanet_green_tab))
            tabs.setBackgroundColor(resources.getColor(R.color.startupplanet_green_tab))

        }
        if (get_track == "3") {
            //trackname.text = "BUSINESS TRACK"
            toolbar.setBackgroundColor(resources.getColor(R.color.business_red))
            tabs.setBackgroundColor(resources.getColor(R.color.business_red))

        }
        if (get_track == "4") {
            //trackname.text = "INNOVATION"
            toolbar.setBackgroundColor(resources.getColor(R.color.innovation_grey))
            tabs.setBackgroundColor(resources.getColor(R.color.innovation_grey))

        }
*/

        val tabLayout = findViewById(R.id.tabs) as TabLayout
        tabLayout.setupWithViewPager(mViewPager)

    }


    /*override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }*/

    /*override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }*/

    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment? {
            val bundle = Bundle()
            when (position) {
                0 -> {

                    val tab1 = Schedules()

                    bundle.putString("track", get_track)
                    bundle.putString("day", "1")
                    tab1.arguments = bundle
                    return tab1
                }
                1 -> {
                    val tab2 = Schedules()
                    bundle.putString("track", get_track)
                    bundle.putString("day", "2")
                    tab2.arguments = bundle
                    return tab2
                }

                2 -> {
                    val tab3 = Schedules()
                    bundle.putString("track", get_track)
                    bundle.putString("day", "3")
                    tab3.arguments = bundle
                    return tab3
                }
                else -> return null
            }

        }

        override fun getCount(): Int {
            return 3
        }

        override fun getPageTitle(position: Int): CharSequence? {
            when (position) {
                0 -> return "DAY 1"
                1 -> return "DAY 2 "
                2 -> return "DAY 3 "
            }
            return null
        }
    }
}
