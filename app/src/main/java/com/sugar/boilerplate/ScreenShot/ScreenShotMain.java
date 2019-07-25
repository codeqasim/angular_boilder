package com.sugar.boilerplate.ScreenShot;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sugar.boilerplate.BaseActivity;
import com.sugar.boilerplate.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ScreenShotMain extends BaseActivity {

    Button btnScreenShot;
    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_shot_main);

        btnScreenShot=findViewById(R.id.btnScreenShot);

        btnScreenShot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Bitmap bitmap = takeScreenshot();
                saveBitmap(bitmap);

                Toast.makeText(ScreenShotMain.this,"Captured",Toast.LENGTH_SHORT).show();
            }
        });
    }



    public Bitmap takeScreenshot() {
        View rootView = findViewById(android.R.id.content).getRootView();
        rootView.setDrawingCacheEnabled(true);
        return rootView.getDrawingCache();
    }

    public void saveBitmap( Bitmap bitmap ) {
        File imagePath = new File(Environment.getExternalStorageDirectory() + "/screenshot.png");
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(imagePath);
            bitmap.compress(Bitmap.CompressFormat.PNG,100,fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            Log.e("GREC",e.getMessage(),e);
        } catch (IOException e) {
            Log.e("GREC",e.getMessage(),e);
        }
    }

}
