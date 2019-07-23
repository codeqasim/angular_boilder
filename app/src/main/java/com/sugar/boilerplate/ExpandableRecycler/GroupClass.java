package com.sugar.boilerplate.ExpandableRecycler;

import android.support.annotation.NonNull;

import com.hgdendi.expandablerecycleradapter.BaseExpandableRecyclerViewAdapter;

import java.util.List;

public class GroupClass implements BaseExpandableRecyclerViewAdapter.BaseGroupBean<ChildCLass> {

    private List<ChildCLass> mList;

    public void setmName( String mName ) {
        this.mName = mName;
    }

    private String mName;

    public GroupClass() {
    }

    GroupClass( @NonNull List<ChildCLass> list,@NonNull String name) {

        mList = list;
        mName = name;
    }



    @Override
    public int getChildCount() {
        return mList.size();
    }



    @Override

    public boolean isExpandable() {

        return getChildCount() > 0;

    }



    public String getName() {
        return mName;
    }



    @Override
    public ChildCLass getChildAt(int index) {

        return mList.size() <= index ? null : mList.get(index);
    }
}