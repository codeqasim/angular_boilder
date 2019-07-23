package com.sugar.boilerplate.ExpandableRecycler;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import com.hgdendi.expandablerecycleradapter.ViewProducer;
import com.sugar.boilerplate.R;

import java.util.ArrayList;
import java.util.List;

public class ExpandRecyclerViewMain extends AppCompatActivity {

    RecyclerView recyclerView;
    ExpandableRecyclerViewAdapter adapter;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expand_recycler_main);
        recyclerView = findViewById(R.id.recyclerview);

        List<GroupClass> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            final List<ChildCLass> childList = new ArrayList<>(i);
            for (int j = 0; j < i; j++) {
                childList.add(new ChildCLass("child " + i));
            }
            list.add(new GroupClass(childList,"group " + i));

        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ExpandableRecyclerViewAdapter(list);

        adapter.setEmptyViewProducer(new ViewProducer() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup parent ) {
                return new DefaultEmptyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.empty,parent,false)
                );
            }

            @Override
            public void onBindViewHolder( RecyclerView.ViewHolder holder ) {

            }
        });

        recyclerView.setAdapter(adapter);

    }


    public void show( Activity activity ) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0,InputMethodManager.HIDE_IMPLICIT_ONLY); // show
    }

    public void hide( Activity activity ) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY,0); // hide
    }

    public void toggle( Activity activity ) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (imm.isActive()) {
            hide(activity);
        } else {
            show(activity);
        }
    }
}


