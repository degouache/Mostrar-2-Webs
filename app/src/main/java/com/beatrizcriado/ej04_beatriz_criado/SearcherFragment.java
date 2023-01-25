package com.beatrizcriado.ej04_beatriz_criado;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SearcherFragment extends Fragment {
    EditText webOneET;
    EditText webTwoET;
    String webOneURL;
    String webTwoURL;
    MainActivity mainActivity;
    Button buttonGetWebOne;
    Button buttonGetWebTwo;
    ImageView foxy;
    ProgressBar progressBar;
    TextView goSeeYourWeb;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.searcher_fragment, container, false);

        webOneET = view.findViewById(R.id.webOneET);
        webTwoET = view.findViewById(R.id.webTwoET);
        mainActivity = (MainActivity) getActivity();
        buttonGetWebOne = view.findViewById(R.id.webOneBT);
        buttonGetWebOne.setOnClickListener(this::getWebOne);
        buttonGetWebTwo = view.findViewById(R.id.webTwoBT);
        buttonGetWebTwo.setOnClickListener(this::getWebTwo);
        foxy = view.findViewById(R.id.foxy);
        goSeeYourWeb = view.findViewById(R.id.goSeeYourWeb);
        progressBar = view.findViewById(R.id.progressBar);
        return view;
    }

    public void getWebOne(View view) {
        Log.d("MainActivity", "Button clicked");
        webOneURL = webOneET.getText().toString();
        if (webOneURL.equals("")) {
            Toast.makeText(mainActivity, "URL one it's empty", Toast.LENGTH_SHORT).show();

        } else {
            Bundle urlOne = new Bundle();
            urlOne.putString("urlOne", webOneURL);
            getParentFragmentManager().setFragmentResult("urlOne", urlOne);
            Toast.makeText(mainActivity, "Go see web one", Toast.LENGTH_SHORT).show();
            new CountDownTimer(2000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    progressBar.setVisibility(View.VISIBLE);
                    goSeeYourWeb.setVisibility(View.VISIBLE);
                }
                @Override
                public void onFinish() {
                    progressBar.setVisibility(View.INVISIBLE);
                    goSeeYourWeb.setVisibility(View.INVISIBLE);
                }
            }.start();
        }
    }

    public void getWebTwo(View view) {
        Log.d("MainActivity", "Button clicked");
        webTwoURL = webTwoET.getText().toString();
        if (webTwoURL.equals("")) {
            Toast.makeText(mainActivity, "URL two it's empty", Toast.LENGTH_SHORT).show();
        } else {
            Bundle urlTwo = new Bundle();
            urlTwo.putString("urlTwo", webTwoURL);
            getParentFragmentManager().setFragmentResult("urlTwo", urlTwo);
            progressBar.setVisibility(View.VISIBLE);
            goSeeYourWeb.setVisibility(view.VISIBLE);
            Toast.makeText(mainActivity, "Go see web two", Toast.LENGTH_SHORT).show();
            new CountDownTimer(2000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    progressBar.setVisibility(View.VISIBLE);
                    goSeeYourWeb.setVisibility(View.VISIBLE);
                }
                @Override
                public void onFinish() {
                    progressBar.setVisibility(View.INVISIBLE);
                    goSeeYourWeb.setVisibility(View.INVISIBLE);
                }
            }.start();
            
        }
    }
}
