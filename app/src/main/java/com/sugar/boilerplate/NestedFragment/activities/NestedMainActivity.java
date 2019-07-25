package com.sugar.boilerplate.NestedFragment.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;

import com.sbrukhanda.fragmentviewpager.FragmentViewPager;
import com.sbrukhanda.fragmentviewpager.adapters.FragmentPagerAdapter;
import com.sbrukhanda.fragmentviewpager.adapters.FragmentStatePagerAdapter;
import com.sugar.boilerplate.NestedFragment.fragments.CompoundFragment;
import com.sugar.boilerplate.NestedFragment.fragments.SimpleFragment;
import com.sugar.boilerplate.R;

import java.util.ArrayList;
import java.util.List;

public class NestedMainActivity extends AppCompatActivity
{

    private static final int LOG_HISTORY_SIZE = 5;

    private FragmentViewPager mFragmentsPager;
    private TabLayout mFragmentsTab;

    private List<String> mLogsHistory;

    // *********************************************************************************************
    public NestedMainActivity() {
        mLogsHistory = new ArrayList<>(LOG_HISTORY_SIZE);
    }

    // *********************************************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nested_activity_main);


        mFragmentsPager = (FragmentViewPager) findViewById(R.id.pager_fragments);
        mFragmentsPager.setOffscreenPageLimit(1);

        PagerAdapter pagerAdapter = new FragmentStateAdapter(getSupportFragmentManager());
        mFragmentsPager.setAdapter(pagerAdapter);

        mFragmentsTab = (TabLayout) findViewById(R.id.tabs_main);
        mFragmentsTab.setupWithViewPager(mFragmentsPager);
    }

    // *********************************************************************************************
    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        mFragmentsPager.notifyPagerVisible();
    }

    // *********************************************************************************************
    @Override
    public void onPause() {
        super.onPause();
        mFragmentsPager.notifyPagerInvisible();
    }

    // *********************************************************************************************
    public void logMessage(String msg) {
        // Return as nothing to log
        if (TextUtils.isEmpty(msg)) return;

        mLogsHistory.add(msg);

        // Remove first item in order to keep history within predefined bounds
        if (mLogsHistory.size() > LOG_HISTORY_SIZE) mLogsHistory.remove(0);

        String separator = "";
        String text = "";

        // Assemble log
        for (String log : mLogsHistory) {
            text += separator + log;
            separator = "\n";
        }

        // show which fragment is visible
//        if (!isFinishing()) mLogsLabel.setText(text);
    }


    // =============================================================================================
    // Inner Classes
    // =============================================================================================

    // *********************************************************************************************
    private class FragmentAdapter extends FragmentPagerAdapter
    {
        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment instantiateFragment( int position) {
            String name = "Fragment " + position;
            switch (position) {
                case 1:
                case 2:
                    return CompoundFragment.newInstance(name);

                default:
                    return SimpleFragment.newInstance(name);
            }
        }

        @Override
        public int getCount() {
            return 4;
        }

        public CharSequence getPageTitle( int position) {
            return String.valueOf(position);
        }
    }

    // *********************************************************************************************
    private class FragmentStateAdapter extends FragmentStatePagerAdapter
    {
        public FragmentStateAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment instantiateFragment( int position) {
            String name = "Fragment " + position;
            switch (position) {
                case 1:
                case 2:
                    return CompoundFragment.newInstance(name);

                default:
                    return SimpleFragment.newInstance(name);
            }
        }

        @Override
        public int getCount() {
            return 4;
        }

        public CharSequence getPageTitle( int position) {
            return String.valueOf("Fragment "+position);
        }
    }
}