package com.sugar.boilerplate.CustomDrawer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.sugar.boilerplate.R;

import java.util.ArrayList;

public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.MenuViewHolder> {
    private static final int Head_Type=0;
    private static final int Item_Type=1;
    private ArrayList<DrawerModel> drawerItemsArrayList;
    private Context context;
    DrawerModel drawerList_provider;
    public ItemClickListner itemClickListner;
    public DrawerAdapter( ArrayList<DrawerModel> drawerList_providers) {
        this.drawerItemsArrayList = drawerList_providers;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder( @NonNull ViewGroup parent,int viewType) {

        if(viewType==Head_Type){
            context =parent.getContext();
            View view= LayoutInflater.from(context).inflate(R.layout.drawer_header_layout,parent,false);
            return new MenuViewHolder(view,viewType);
        }
        else if(viewType==Item_Type){
            context=parent.getContext();
            View view= LayoutInflater.from(context).inflate(R.layout.drawer_items_layout,parent,false);
            return new MenuViewHolder(view,viewType);
        }
        return null;

    }

    @Override
    public void onBindViewHolder( @NonNull final MenuViewHolder holder,final int position) {
        if(holder.view_Type==Head_Type){
            holder.headerCircleImageView.setImageResource(R.mipmap.ic_launcher);
            holder.headerTextTitle.setText(context.getResources().getString(R.string.app_name));
        }
        else if(holder.view_Type==Item_Type) {
            drawerList_provider = drawerItemsArrayList.get(position - 1);
            holder.txtDrawerItems.setText(drawerList_provider.getDrawerNmae());
       }

    }

    @Override
    public int getItemCount() {
        return drawerItemsArrayList.size()+1;
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder{
        int view_Type;
              // variables for Items
        public ImageButton imageButtonDrawerImages;
        public TextView txtDrawerItems;
             // variables for drawer_header_layout
        public ImageView headerCircleImageView;
        public TextView headerTextTitle,headerTextSubtitle;

        public MenuViewHolder( final View itemView,int viewType) {
            super(itemView);
            if(viewType==Head_Type){
                headerCircleImageView=itemView.findViewById(R.id.headerCircleImageView);
                headerTextTitle=itemView.findViewById(R.id.headerTextTitle);
                headerTextSubtitle=itemView.findViewById(R.id.headerTextSubtitle);
                view_Type=0;
            }
            else if(viewType == Item_Type){
                txtDrawerItems=itemView.findViewById(R.id.txtDrawerItems);
                view_Type=1;
            }
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClickListner.onClickInterface(view, getAdapterPosition());

                }
            });

        }

    }
    public void setItemCLickListner(ItemClickListner itemCLickListner){
        this.itemClickListner=itemCLickListner;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0)
            return Head_Type;
            return Item_Type;
    }
}
