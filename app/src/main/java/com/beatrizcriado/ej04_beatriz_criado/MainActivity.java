package com.beatrizcriado.ej04_beatriz_criado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabsNavigation;
    ViewPager pagesVP;
    PageAdapter pageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tabs
        tabsNavigation = findViewById(R.id.tabsNavigation);
        pagesVP = findViewById(R.id.pagesVP);
        pageAdapter = new PageAdapter(getSupportFragmentManager(),this);
        pagesVP.setAdapter(pageAdapter);
        tabsNavigation.setupWithViewPager(pagesVP);


        }

    public void webOneSettingURL (String webOneURL){
        Log.i("MainActivity", webOneURL);
    }

    }

