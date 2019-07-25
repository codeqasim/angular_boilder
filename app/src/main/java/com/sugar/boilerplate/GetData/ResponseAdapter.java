package com.sugar.boilerplate.GetData;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sugar.boilerplate.Network.Request.MainResponse;
import com.sugar.boilerplate.R;

import java.util.ArrayList;

public class ResponseAdapter extends RecyclerView.Adapter<ResponseAdapter.ResponseViewHolder> {

    ArrayList<MainResponse> mainResponseArrayList;
    Context context;

    public ResponseAdapter( ArrayList<MainResponse> mainResponseArrayList,Context context ) {
        this.mainResponseArrayList = mainResponseArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ResponseViewHolder onCreateViewHolder( @NonNull ViewGroup viewGroup,int i ) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.custom_response,viewGroup,false);
        return new ResponseViewHolder(view);
    }

    @Override
    public void onBindViewHolder( @NonNull ResponseViewHolder holder,int i ) {

        holder.txtTitle.setText("Title: "+mainResponseArrayList.get(i).getTitle());
        holder.txtBody.setText("Body: "+mainResponseArrayList.get(i).getBody());

    }

    @Override
    public int getItemCount() {
        return mainResponseArrayList.size();
    }

    public class ResponseViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle, txtBody;

        public ResponseViewHolder( @NonNull View itemView ) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtBody = itemView.findViewById(R.id.txtBody);
        }
    }
}
