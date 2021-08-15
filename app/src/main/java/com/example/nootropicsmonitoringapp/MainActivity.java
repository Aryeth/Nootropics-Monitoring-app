package com.example.nootropicsmonitoringapp;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout =findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.view_pager);
        getTabs();


    }

    public void getTabs(){
        final  ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        new Handler().post(new Runnable() {
            @Override
            public void run() {


                ViewPagerAdapter.addFragment(EffectListFragment.getInstance(), "Effect List");
                ViewPagerAdapter.addFragment(CalendarFragment.getInstance(), "Calendar");
                ViewPagerAdapter.addFragment(RecapFragment.getInstance(), "Recap");

                viewPager.setAdapter(viewPagerAdapter);

                tabLayout.setupWithViewPager(viewPager);
            }
        });

    }
}