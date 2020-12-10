package com.example.basketballmanagerv3.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.basketballmanagerv3.R;

public class Fragment3 extends Fragment {
    private static final String TAG = "Fragment3";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment3_settings, container, false);

        getActivity().setTitle("Settings");
        return view;
    }
}

