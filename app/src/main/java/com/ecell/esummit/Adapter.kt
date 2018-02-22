package com.ecell.esummit

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

/**
 * Created by 1505560 on 21-Feb-18.
 */
internal class Adapter(private val array_time: List<String>, private val array_title: List<String>, private val array_venue: List<String>, private val array_description: List<String>, private val array_speaker: List<String>, private val array_profile: List<String>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    private var time: TextView? = null
    private var title: TextView? = null
    private var venue: TextView? = null
    private var description: TextView? = null
    private var speaker: TextView? = null
    private var header: LinearLayout? = null

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            time = view.findViewById(R.id.time) as TextView
            title = view.findViewById(R.id.title) as TextView
            venue = view.findViewById(R.id.venue) as TextView
            description = view.findViewById(R.id.description) as TextView
            speaker = view.findViewById(R.id.speaker) as TextView
            header = view.findViewById(R.id.header) as LinearLayout
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.cards, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        time!!.text = array_time[position]
        title!!.text = array_title[position]
        venue!!.text = "  "+array_venue[position]
        description!!.text = array_description[position]
        speaker!!.text = array_speaker[position]
    }

    override fun getItemCount(): Int {
        return array_title.size
    }
}
