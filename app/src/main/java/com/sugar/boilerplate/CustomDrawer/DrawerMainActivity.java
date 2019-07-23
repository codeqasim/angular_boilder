package com.sugar.boilerplate.CustomDrawer;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;


import com.sugar.boilerplate.Fragments.Home;
import com.sugar.boilerplate.Fragments.About;
import com.sugar.boilerplate.Fragments.ContectUs;
import com.sugar.boilerplate.R;

import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.N)
public class DrawerMainActivity extends AppCompatActivity {
    public TextView tvAppTitle;
    Toolbar toolbar;
    DrawerAdapter drawerAdapter;
    RecyclerView recyclerView;
    ArrayList<DrawerModel> drawerItemsArrayList;
    String[] Name;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    //    CalendarView calendarView;
    FrameLayout frameLayout;
    private boolean isExpanded = false;
    private AppBarLayout appBarLayout;

    @SuppressLint({"NewApi","HardwareIds"})
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_drawer);

        initial();
        adapterData();
        setFragment(new Home());
        //  txtHotelSearch.setText(read);
        appBarLayout.setVisibility(View.VISIBLE);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        tvAppTitle.setText(getString(R.string.app_name));


        drawerAdapter.setItemCLickListner(new ItemClickListner() {
            @Override
            public void onClickInterface( View view,int position ) {

                for (int i = 1; i < drawerItemsArrayList.size(); i++) {
                    // get the views from view recyclerView adapter
                    DrawerAdapter.MenuViewHolder mv = (DrawerAdapter.MenuViewHolder) recyclerView.getChildViewHolder(recyclerView.getChildAt(i));
                    if (i == position) {
                        mv.txtDrawerItems.setTextColor(getResources().getColor(R.color.colorDrawerBlue));
                    } else {
                        mv.txtDrawerItems.setTextColor(getResources().getColor(R.color.colorDrawerDark));
                    }
                }

                switch (position) {
                    case 1:
                        setFragment(new Home());
                        drawerLayout.closeDrawers();
                        break;
                    case 2:
                        setFragment(new About());
                        drawerLayout.closeDrawers();
                        break;
                    case 3:
                        setFragment(new ContectUs());
                        drawerLayout.closeDrawers();
                        break;

                }
            }
        });

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(
                this,drawerLayout,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close
        );
        drawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

    }

    private void exitDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Warning");
        alertDialog.setIcon(android.R.drawable.stat_sys_warning);
        alertDialog.setMessage("Are you sure to want to Exit");
        alertDialog.setCancelable(false);
        alertDialog.setIcon(R.mipmap.ic_launcher_round);
        alertDialog.setPositiveButton("yes",new DialogInterface.OnClickListener() {
            @Override
            public void onClick( DialogInterface dialogInterface,int i ) {
                finish();
            }
        }).setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick( DialogInterface dialogInterface,int i ) {
                dialogInterface.dismiss();
            }
        }).show();
    }

    private void initial() {
        drawerItemsArrayList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        tvAppTitle = findViewById(R.id.tvAppTitle);
        drawerLayout = findViewById(R.id.drawer_layout);
        appBarLayout = findViewById(R.id.app_bar_layout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        frameLayout = findViewById(R.id.content_frame);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void adapterData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        Name = getResources().getStringArray(R.array.menuItems);
        int count = 0;
        for (String Name : Name) {
            DrawerModel drawerList_provider = new DrawerModel(Name);
            drawerItemsArrayList.add(drawerList_provider);
            count++;
        }
        drawerAdapter = new DrawerAdapter(drawerItemsArrayList);
        recyclerView.setAdapter(drawerAdapter);

    }

    private void setFragment( Fragment fragment ) {
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,fragment).commit();
    }

}

