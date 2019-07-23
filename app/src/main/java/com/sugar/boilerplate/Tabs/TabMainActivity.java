package com.sugar.boilerplate.Tabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.sugar.boilerplate.Fragments.Home;
import com.sugar.boilerplate.Fragments.About;
import com.sugar.boilerplate.Fragments.ContectUs;
import com.sugar.boilerplate.R;

public class TabMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_layout);

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("Fragment 1", Home.class)
                .add("Framgent 2", About.class)
                .add("Framgent 3", ContectUs.class)
                .create());

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager(viewPager);
    }
}
