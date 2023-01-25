package com.beatrizcriado.ej04_beatriz_criado;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {
    SearcherFragment searcherFragment;
    WebOneFragment webOneFragment;
    WebTwoFragment webTwoFragment;
    Context context;

    public PageAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.context = context;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                if (searcherFragment == null) {
                    searcherFragment = new SearcherFragment();
                }
                fragment = searcherFragment;
                break;
            case 1:
                if (webOneFragment == null) {
                    webOneFragment = new WebOneFragment();
                }
                fragment = webOneFragment;
                break;
            case 2:
                if (webTwoFragment == null) {
                    webTwoFragment = new WebTwoFragment();
                }
                fragment = webTwoFragment;
                break;
            default:
                fragment = null;
        }
        return fragment; //Hacer un if para not null si da tiempo
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String titulo;
        switch (position) {
            case 0:
                titulo = context.getString(R.string.searcherTab);
                break;
            case 1:
                titulo = context.getString(R.string.WebOneTab);
                break;
            case 2:
                titulo = context.getString(R.string.WebtwoTab);
                break;
            default:
                titulo = "";
        }
        return titulo;
    }

}

