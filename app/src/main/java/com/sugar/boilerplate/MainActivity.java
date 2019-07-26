package com.sugar.boilerplate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sugar.boilerplate.AppIntro.AppIntroMainActivity;
import com.sugar.boilerplate.CustomDrawer.DrawerMainActivity;
import com.sugar.boilerplate.ExpandableRecycler.ExpandRecyclerViewMain;
import com.sugar.boilerplate.FilterableRecyclerView.FiterMainActivity;
import com.sugar.boilerplate.GetData.GetResponseData;
import com.sugar.boilerplate.ImagePicker.ImagePickerMain;
import com.sugar.boilerplate.Map.MapsActivity;
import com.sugar.boilerplate.NestedFragment.activities.NestedMainActivity;
import com.sugar.boilerplate.ScreenShot.ScreenShotMain;
import com.sugar.boilerplate.SocialLogin.SocailMainActivity;
import com.sugar.boilerplate.Splash.SplashScreen;
import com.sugar.boilerplate.Tabs.TabMainActivity;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    ListView mainItemsList;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> itemsList = new ArrayList<>();

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainItemsList = findViewById(R.id.mainItemsList);

        itemsList.add("App Intro");
        itemsList.add("Splash Screen");
        itemsList.add("Drawer");
        itemsList.add("Tabs");
        itemsList.add("Social Login");
        itemsList.add("Expandable ListView");
        itemsList.add("Map");
        itemsList.add("Nested Fragment");
        itemsList.add("Screen Shot");
        itemsList.add("Api-Response");
        itemsList.add("Filterable List");
        itemsList.add("MultiImage Picker");


        arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,itemsList);
        mainItemsList.setAdapter(arrayAdapter);


        mainItemsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick( AdapterView<?> parent,View view,int position,long id ) {

                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this,AppIntroMainActivity.class));
                        break;

                    case 1:
                        startActivity(new Intent(MainActivity.this,SplashScreen.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this,DrawerMainActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this,TabMainActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this,SocailMainActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(MainActivity.this,ExpandRecyclerViewMain.class));
                        break;
                    case 6:
                        startActivity(new Intent(MainActivity.this,MapsActivity.class));
                        break;
                    case 7:
                        startActivity(new Intent(MainActivity.this,NestedMainActivity.class));
                        break;
                    case 8:
                        startActivity(new Intent(MainActivity.this,ScreenShotMain.class));
                        break;
                    case 9:
                        startActivity(new Intent(MainActivity.this,GetResponseData.class));
                        break;
                    case 10:
                        startActivity(new Intent(MainActivity.this,FiterMainActivity.class));
                        break;
                        case 11:
                        startActivity(new Intent(MainActivity.this,ImagePickerMain.class));
                        break;
                }

            }
        });

    }
}
