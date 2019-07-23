package com.sugar.boilerplate.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sugar.boilerplate.R;


public class Home extends Fragment {

    View view;

    @Nullable
    @Override
    public View onCreateView( @NonNull LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState ) {
        return view=inflater.inflate(R.layout.fragment1,container,false);
    }

    @Override
    public void onViewCreated( @NonNull View view,@Nullable Bundle savedInstanceState ) {
        super.onViewCreated(view,savedInstanceState);


    }
}
