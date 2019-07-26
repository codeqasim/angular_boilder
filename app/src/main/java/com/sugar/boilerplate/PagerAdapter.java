package com.sugar.boilerplate;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sugar.boilerplate.Fragments.About;
import com.sugar.boilerplate.Fragments.ContectUs;
import com.sugar.boilerplate.Fragments.Home;


public class PagerAdapter extends FragmentPagerAdapter {
    Context context;
    // tab titles
    private String[] tabTitles = new String[]{"Home","About","Contact Us"};

    public PagerAdapter( FragmentManager fm ) {
        super(fm);

    }

    // overriding getPageTitle()
    @Override
    public CharSequence getPageTitle( int position ) {
        return tabTitles[position];
    }

    @Override
    public Fragment getItem( int index ) {

        switch (index) {
            case 0:
                return new Home();
            case 1:
                return new About();
            case 2:
                return new ContectUs();
        }
        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }

}
