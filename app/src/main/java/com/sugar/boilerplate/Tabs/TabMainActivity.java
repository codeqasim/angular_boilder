package com.sugar.boilerplate.Tabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;

import com.kekstudio.dachshundtablayout.DachshundTabLayout;
import com.kekstudio.dachshundtablayout.HelperUtils;
import com.kekstudio.dachshundtablayout.indicators.DachshundIndicator;
import com.kekstudio.dachshundtablayout.indicators.LineFadeIndicator;
import com.kekstudio.dachshundtablayout.indicators.LineMoveIndicator;
import com.kekstudio.dachshundtablayout.indicators.PointFadeIndicator;
import com.kekstudio.dachshundtablayout.indicators.PointMoveIndicator;
import com.sugar.boilerplate.PagerAdapter;
import com.sugar.boilerplate.R;

public class TabMainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private DachshundTabLayout tabLayout;

    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_layout);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));


        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

    }


    public void onClickDachshund( View view ) {

        tabLayout.setAnimatedIndicator(new DachshundIndicator(tabLayout));

    }


    public void onClickPointMove( View view ) {

        tabLayout.setAnimatedIndicator(new PointMoveIndicator(tabLayout));

    }


    public void onClickPointMoveAccelerate( View view ) {
        PointMoveIndicator pointMoveIndicator = new PointMoveIndicator(tabLayout);
        pointMoveIndicator.setInterpolator(new AccelerateInterpolator());
        tabLayout.setAnimatedIndicator(pointMoveIndicator);

    }


    public void onClickLineMove( View view ) {

        tabLayout.setAnimatedIndicator(new LineMoveIndicator(tabLayout));

    }


    public void onClickPointFade( View view ) {

        tabLayout.setAnimatedIndicator(new PointFadeIndicator(tabLayout));

    }


    public void onClickLineFade( View view ) {

        LineFadeIndicator lineFadeIndicator = new LineFadeIndicator(tabLayout);

        tabLayout.setAnimatedIndicator(lineFadeIndicator);


        lineFadeIndicator.setSelectedTabIndicatorHeight(HelperUtils.dpToPx(2));

        lineFadeIndicator.setEdgeRadius(0);

    }

}