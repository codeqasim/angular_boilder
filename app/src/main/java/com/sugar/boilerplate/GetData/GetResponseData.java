package com.sugar.boilerplate.GetData;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.sugar.boilerplate.Network.Request.MainResponse;
import com.sugar.boilerplate.Network.Retrofit.AppController;
import com.sugar.boilerplate.Network.Utils.Constants;
import com.sugar.boilerplate.Network.Utils.Util;
import com.sugar.boilerplate.R;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetResponseData extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    ArrayList<MainResponse> mainResponseArrayList;
    ResponseAdapter responseAdapter;
    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_response_main);

        recyclerView=findViewById(R.id.recyclerView);
        progressBar=findViewById(R.id.progressBar);
        mainResponseArrayList=new ArrayList<>();

        getResponse();

    }


    private void getResponse( ) {
        if (!Util.isConnectingToInternet(this.getWindow().getContext())) {
            Util.showToastMsg(this.getWindow().getContext(),Constants.kStringNetworkConnectivityError);
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        Call<List<MainResponse>> call = AppController.getApiInterface().getApiResponse();
        call.enqueue(new Callback<List<MainResponse>>() {
            @Override
            public void onResponse( @NonNull Call<List<MainResponse>> call,@NonNull Response<List<MainResponse>> response ) {

                progressBar.setVisibility(View.INVISIBLE);

                assert response.body() != null;
                if (response.isSuccessful()) {

                    mainResponseArrayList= (ArrayList<MainResponse>) response.body();

                    recyclerView.setLayoutManager(new LinearLayoutManager(GetResponseData.this));
                    responseAdapter=new ResponseAdapter(mainResponseArrayList,GetResponseData.this);
                    recyclerView.setAdapter(responseAdapter);
                }
            }

            @Override
            public void onFailure( @NonNull Call<List<MainResponse>> call,@NonNull Throwable t ) {
                progressBar.setVisibility(View.INVISIBLE);
                Log.e(Constants.EXCEPTION,t.getMessage());
                Toast.makeText(GetResponseData.this,t.getMessage(),Toast.LENGTH_SHORT).show();
                // Util.showToastMsg(getApplicationContext(), Constants.SERVER_EXCEPTION_MESSAGE);
            }
        });
    }

}
