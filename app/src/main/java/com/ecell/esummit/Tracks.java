package com.ecell.esummit;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by Niklaus on 26-Feb-17.
 */

public class Tracks extends AppCompatActivity {
    private String get_track;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private TextView trackname;
    private Toolbar toolbar;
    private ViewPager mViewPager;
    private TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tracks);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        tabs=(TabLayout)findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        trackname=(TextView)findViewById(R.id.trackname);
        get_track = getIntent().getStringExtra("track");

        if(get_track.equals( "1")) {
            trackname.setText("Technology Track");
            toolbar.setBackgroundColor(getResources().getColor(R.color.technology));
            tabs.setBackgroundColor(getResources().getColor(R.color.technology));
        }
        if(get_track.equals("2")){
            trackname.setText("Startup Planet");
            toolbar.setBackgroundColor(getResources().getColor(R.color.startup));
            tabs.setBackgroundColor(getResources().getColor(R.color.startup));
        }
        if(get_track.equals("3")){
            trackname.setText("Business Track");
            toolbar.setBackgroundColor(getResources().getColor(R.color.business));
            tabs.setBackgroundColor(getResources().getColor(R.color.business));
        }
        if(get_track.equals("4")){
            trackname.setText("Innovation Track");
            toolbar.setBackgroundColor(getResources().getColor(R.color.innovation));
            tabs.setBackgroundColor(getResources().getColor(R.color.innovation));
        }

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Bundle bundle = new Bundle();
            switch (position) {
                case 0:
                    Schedules tab1 = new Schedules();
                    bundle.putString("track", get_track);
                    bundle.putString("day", "1");
                    tab1.setArguments(bundle);
                    return tab1;
                case 1:
                    Schedules tab2 = new Schedules();
                    bundle.putString("track", get_track);
                    bundle.putString("day", "2");
                    tab2.setArguments(bundle);
                    return tab2;
                case 2:
                    Schedules tab3 = new Schedules();
                    bundle.putString("track", get_track);
                    bundle.putString("day", "3");
                    tab3.setArguments(bundle);
                    return tab3;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Day 1";
                case 1:
                    return "Day 2 ";
                case 2:
                    return "Day 3 ";
            }
            return null;
        }
    }
}
