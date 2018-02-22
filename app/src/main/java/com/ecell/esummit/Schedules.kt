package com.ecell.esummit

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject
import java.util.ArrayList

/**
 * Created by 1505560 on 21-Feb-18.
 */
class Schedules : Fragment() {
    private val get_track: String? = null
    private val get_time: String? = null
    private val get_title: String? = null
    private val get_venue: String? = null
    private val get_description: String? = null
    private val get_speaker: String? = null
    private val get_profile: String? = null

    private var array_time: MutableList<String>? = null
    private var array_title: MutableList<String>? = null
    private var array_venue: MutableList<String>? = null
    private var array_description: MutableList<String>? = null
    private var array_speaker: MutableList<String>? = null
    private var array_profile: List<String>? = null

    private var recyclerView: RecyclerView? = null
    private var adapter: RecyclerView.Adapter<*>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.recycler, container, false)
        array_time = ArrayList()
        array_title = ArrayList()
        array_venue = ArrayList()
        array_description = ArrayList()
        array_speaker = ArrayList()
        array_profile = ArrayList()

        recyclerView = view.findViewById(R.id.recycler)
        recyclerView!!.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(activity)
        recyclerView!!.layoutManager = layoutManager

        val track = arguments.getString("track")
        val day = arguments.getString("day")
        Log.i("testingtrack", track)


        getData(track, day)

        return view
    }

    private fun getData(track: String?, day: String?) {
        val url = "$DATA_URL?track=$track&day=$day"

        val stringRequest = StringRequest(url, Response.Listener { response -> showJSON(response) }, Response.ErrorListener { })
        val requestQueue = Volley.newRequestQueue(activity)
        requestQueue.add(stringRequest)
    }

    private fun showJSON(response: String) {
        try {
            val jsonObject = JSONObject(response)
            val result = jsonObject.getJSONArray("result")

            for (i in 0 until result.length()) {
                val get_data = result.getJSONObject(i)

                array_time!!.add(get_data.getString("time"))
                array_title!!.add(get_data.getString("title"))
                array_venue!!.add(get_data.getString("venue"))
                array_description!!.add(get_data.getString("description"))

                if (get_data.getString("speaker") != null) {
                    array_speaker!!.add(get_data.getString("speaker"))
                }
                //                array_profile.add(get_data.getString("profile"));
            }

            adapter = Adapter(this!!.array_time!!, this!!.array_title!!, this!!.array_venue!!, this!!.array_description!!, this!!.array_speaker!!, this!!.array_profile!!)
            recyclerView!!.adapter = adapter
        } catch (e: JSONException) {
        }

    }

    companion object {

        internal var DATA_URL = "http://kiitecell.hol.es/esummit181.php"
    }
}
