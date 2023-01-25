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

public class WebOneFragment extends Fragment {

    WebView webOne;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.webone_fragment, container, false);

        webOne = view.findViewById(R.id.webOne);


        getParentFragmentManager().setFragmentResultListener("urlOne", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String webOneRecived = result.getString("urlOne");
                Log.d("web recibida", webOneRecived);
                webOne.loadUrl(webOneRecived);
                webOne.setWebViewClient(new WebViewClient());

            }
        });

        return view;

    }
}
