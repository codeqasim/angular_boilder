package com.sugar.boilerplate.ImagePicker;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.darsh.multipleimageselect.activities.AlbumSelectActivity;
import com.darsh.multipleimageselect.helpers.Constants;
import com.darsh.multipleimageselect.models.Image;
import com.sugar.boilerplate.R;

import java.util.ArrayList;

public class ImagePickerMain extends AppCompatActivity {

    public static final int numberOfImagesToSelect = 3;
    Button btnPickImage;
    ImageView img1, img2, img3;

    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multi_picker_main);


        btnPickImage = findViewById(R.id.btnPickImage);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);


        btnPickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Intent intent = new Intent(ImagePickerMain.this,AlbumSelectActivity.class);
                //set limit on number of images that can be selected, default is 10
                intent.putExtra(Constants.INTENT_EXTRA_LIMIT,numberOfImagesToSelect);
                startActivityForResult(intent,Constants.REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult( int requestCode,int resultCode,Intent data ) {
        if (requestCode == Constants.REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            //The array list has the image paths of the selected images
            ArrayList<Image> images = data.getParcelableArrayListExtra(Constants.INTENT_EXTRA_IMAGES);

            img1.setImageURI(Uri.parse(images.get(0).path));
            img2.setImageURI(Uri.parse(images.get(1).path));
            img3.setImageURI(Uri.parse(images.get(2).path));

        }
    }
}
