package com.ecell.esummit;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URI;
import java.net.URL;

public class Registration extends AppCompatActivity {
Button register , dashboard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        register=(Button) findViewById(R.id.register);
        dashboard=(Button) findViewById(R.id.dashboard);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        actionBar.hide();

      register.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Uri uri =Uri.parse("https://esummit.org.in/#join");
              Intent intent = new Intent(Intent.ACTION_VIEW,uri);
              startActivity(intent);
          }
      });

        dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Registration.this,Dashboard.class);
                startActivity(intent);
            }
        });
}

}
