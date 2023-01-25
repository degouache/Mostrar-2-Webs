package com.beatrizcriado.ej04_beatriz_criado;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;


public class WebTwoFragment extends Fragment {

    WebView webTwo;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.webtwo_fragment, container, false);

        webTwo = view.findViewById(R.id.webTwo);


        getParentFragmentManager().setFragmentResultListener("urlTwo", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String webTwoRecived = result.getString("urlTwo");
                Log.d("web recibida", webTwoRecived);
                webTwo.loadUrl(webTwoRecived);
                webTwo.setWebViewClient(new WebViewClient());

            }
        });

        return view;

    }
}