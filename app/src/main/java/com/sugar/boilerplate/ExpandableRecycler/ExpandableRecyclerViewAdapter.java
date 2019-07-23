package com.sugar.boilerplate.ExpandableRecycler;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hgdendi.expandablerecycleradapter.BaseExpandableRecyclerViewAdapter;
import com.sugar.boilerplate.R;

import java.util.List;


public class ExpandableRecyclerViewAdapter extends
        BaseExpandableRecyclerViewAdapter<GroupClass, ChildCLass, ExpandableRecyclerViewAdapter.GroupVH, ExpandableRecyclerViewAdapter.ChildVH> {
    private List<GroupClass> mList;



    public ExpandableRecyclerViewAdapter(List<GroupClass> list) {

        mList = list;

    }



    @Override

    public int getGroupCount() {

        return mList.size();

    }



    @Override

    public GroupClass getGroupItem(int position) {

        return mList.get(position);

    }



    @Override

    public GroupVH onCreateGroupViewHolder(ViewGroup parent, int groupViewType) {

        return new GroupVH(

                LayoutInflater.from(parent.getContext())

                        .inflate(R.layout.expand_list_group, parent, false));

    }



    @Override

    public ChildVH onCreateChildViewHolder(ViewGroup parent, int childViewType) {

        return new ChildVH(

                LayoutInflater.from(parent.getContext())

                        .inflate(R.layout.expand_list_child, parent, false));

    }



    @Override

    public void onBindGroupViewHolder(GroupVH holder, GroupClass sampleGroupBean, boolean isExpanding) {

        holder.nameTv.setText(sampleGroupBean.getName());

    }



    @Override

    public void onBindChildViewHolder(ChildVH holder, GroupClass groupBean, ChildCLass sampleChildBean) {

        holder.nameTv.setText(sampleChildBean.getName());

    }



    static class GroupVH extends BaseExpandableRecyclerViewAdapter.BaseGroupViewHolder {

        ImageView foldIv;

        TextView nameTv;



        GroupVH(View itemView) {

            super(itemView);

            nameTv = (TextView) itemView.findViewById(R.id.lblListHeader);

        }



        @Override

        protected void onExpandStatusChanged(RecyclerView.Adapter relatedAdapter, boolean isExpanding) {

//            foldIv.setImageResource(isExpanding ? R.drawable.ic_arrow_expanding : R.drawable.ic_arrow_folding);

        }

    }

    static class ChildVH extends RecyclerView.ViewHolder {
        TextView nameTv;
        ChildVH(View itemView) {
            super(itemView);
            nameTv = (TextView) itemView.findViewById(R.id.lblListItem);
        }
    }
}