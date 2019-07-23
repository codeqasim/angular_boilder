package com.sugar.boilerplate.BottomNavigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.sugar.boilerplate.R;


public class BottomNavigationMain extends AppCompatActivity {

    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_navigation_main);
//
//        MeowBottomNavigation bottomNavigation = findViewById(R.id.bottomNavigation);
//        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_facebook_white_36dp));
//        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_google_plus_white_36dp));
//        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_mr_button_grey));
    }
}
