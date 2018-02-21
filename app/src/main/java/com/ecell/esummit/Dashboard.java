package com.ecell.esummit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {
    CardView tech,startup,business,innovation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);



        tech=(CardView) findViewById(R.id.tech);
        startup=(CardView) findViewById(R.id.startup);
        business=(CardView) findViewById(R.id.business);
        innovation=(CardView) findViewById(R.id.innovation);
        tech.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent i = new Intent(Dashboard.this,Tracks.class);
                                        i.putExtra("track", "1");

                                        startActivity(i);
                                    }
                                }
        );
        startup.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent i = new Intent(Dashboard.this,Tracks.class);
                                            i.putExtra("track", "2");

                                            startActivity(i);
                                        }
                                    }
        );
        business.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent i = new Intent(Dashboard.this,Tracks.class);
                                        i.putExtra("track", "3");

                                        startActivity(i);
                                    }
                                }
        );
        innovation.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent i = new Intent(Dashboard.this,Tracks.class);
                                            i.putExtra("track", "4");

                                            startActivity(i);
                                        }
                                    }
        );

    }
}
