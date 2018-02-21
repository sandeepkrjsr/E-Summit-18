package com.ecell.esummit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niklaus on 26-Feb-17.
 */

public class Day extends Fragment {
    private String get_track, get_time, get_title, get_venue, get_description, get_speaker, get_profile;

    private List<String> array_time, array_title, array_venue, array_description, array_speaker, array_profile;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    static String DATA_URL = "http://kiitecell.hol.es/esummit181.php";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.day, container, false);
        array_time = new ArrayList<>();
        array_title = new ArrayList<>();
        array_venue = new ArrayList<>();
        array_description = new ArrayList<>();
        array_speaker = new ArrayList<>();
        array_profile = new ArrayList<>();

        recyclerView = (RecyclerView)view.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        String track = getArguments().getString("track");
        String day = getArguments().getString("day");
        Log.i("testingtrack",track);


            getData(track,day);

        return view;
    }

    private void getData( String track, String day) {
        String url = DATA_URL + "?track=" + track + "&day=" + day;

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showJSON(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }

    private void showJSON(String response){
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray("result");

            for (int i = 0; i < result.length(); i++){
                JSONObject get_data = result.getJSONObject(i);

                array_time.add(get_data.getString("time"));
                array_title.add(get_data.getString("title"));
                array_venue.add(get_data.getString("venue"));
                array_description.add(get_data.getString("description"));

                if(get_data.getString("speaker")!=null) {
                    array_speaker.add(get_data.getString("speaker"));
                }
//                array_profile.add(get_data.getString("profile"));
            }

            adapter = new Adapter_Schedule(array_time, array_title, array_venue, array_description, array_speaker, array_profile);
            recyclerView.setAdapter(adapter);
        } catch (JSONException e) {
        }
    }
}
